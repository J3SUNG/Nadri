package com.ssafy.trip.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.trip.model.dto.BoardDto;
import com.ssafy.trip.model.dto.BoardParameterDto;
import com.ssafy.trip.model.dto.FileInfoDto;
import com.ssafy.trip.model.dto.PlanDto;
import com.ssafy.trip.model.dto.TripDto;
import com.ssafy.trip.service.PlanService;
import com.ssafy.trip.service.TripService;


@RestController
@RequestMapping("plan")
public class PlanController {
	private final Logger logger = LoggerFactory.getLogger(PlanController.class);
	PlanService planService;
	public PlanController(PlanService planService) {
		super();
		this.planService = planService;
	}
	
	@Autowired
	TripService tripService;
	
	@GetMapping("/{planNo}/{userNo}")
	public PlanDto get(@PathVariable("planNo") int planNo,@PathVariable("userNo") int userNo) throws Exception {
		logger.debug("get planNo : {}", planNo);
		planService.updateHit(planNo);
		PlanDto planDto = planService.get(planNo,userNo);
		List<TripDto> trips = tripService.list(planDto.getPlanNo());
		planDto.setTrips(trips);
		return planDto;
	}
	
	@GetMapping("/list/{userNo}")
	public List<PlanDto> list(@PathVariable("userNo") int userNo) throws Exception {
		logger.debug("get all list of plan");
		List<PlanDto> list = planService.list(userNo);
		return list;
	}
	
	@GetMapping("/likelist/{userNo}")
	public List<PlanDto> likelist(@PathVariable("userNo") int userNo) throws Exception {
		logger.debug("get most liked list of plan");
		List<PlanDto> list = planService.likelist(userNo);
		return list;
	}
	
	@PostMapping
	public String write(@RequestParam(required = false) MultipartFile[] files,
			PlanDto planDto) throws Exception {
		logger.debug("**********write plan : {}",planDto);
//		planDto.setContent("plan test");planDto.setEndDate("2022-02-02");planDto.setStartDate("2022-02-02");
//		planDto.setSubject("plan subject");planDto.setUserNo(1); //test
		
		
		if (!files[0].isEmpty()) {
			String realPath = new File("").getAbsolutePath()+"/resources/img";
			String today = new SimpleDateFormat("yyMMdd").format(new Date());
			String saveFolder = realPath + File.separator + today;
			logger.debug("저장 폴더 : {}", saveFolder);
			File folder = new File(saveFolder);
			if (!folder.exists())
				folder.mkdirs();
			List<FileInfoDto> fileInfos = new ArrayList<FileInfoDto>();
			for (MultipartFile mfile : files) {
				FileInfoDto fileInfoDto = new FileInfoDto();
				String originalFileName = mfile.getOriginalFilename();
				if (!originalFileName.isEmpty()) {
					String saveFileName = UUID.randomUUID().toString()
							+ originalFileName.substring(originalFileName.lastIndexOf('.'));
					fileInfoDto.setSaveFolder(today);
					fileInfoDto.setOriginalFile(originalFileName);
					fileInfoDto.setSaveFile(saveFileName);
					logger.debug("원본 파일 이름 : {}, 실제 저장 파일 이름 : {}", mfile.getOriginalFilename(), saveFileName);
					mfile.transferTo(new File(folder, saveFileName));
				}
				fileInfos.add(fileInfoDto);
			}
			planDto.setFileInfos(fileInfos);
		}
		planService.write(planDto);
		return "success";
	}

	@PutMapping
	public PlanDto modify(PlanDto PlanDto) throws Exception {
		logger.debug("modify PlanDto : {}", PlanDto);
		planService.modify(PlanDto);
		return PlanDto;
	}

	@DeleteMapping("/{planNo}")
	public String delete(@PathVariable("planNo") int planNo) throws Exception {
		logger.debug("delete PlanDto : {}", planNo);
		planService.delete(planNo);
		return "success";
	}
}
