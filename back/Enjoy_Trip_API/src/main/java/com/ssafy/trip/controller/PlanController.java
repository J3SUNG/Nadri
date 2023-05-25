package com.ssafy.trip.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public PlanDto get(@PathVariable("planNo") int planNo, @PathVariable("userNo") int userNo) throws Exception {
		logger.debug("get planNo : {}", planNo);
		planService.updateHit(planNo);
		PlanDto planDto = planService.get(planNo, userNo);
		List<TripDto> trips = tripService.list(planDto.getPlanNo());
		for(int i = 0;i<trips.size();i++) {
			if("".equals(trips.get(i).getImage1())) {
				trips.get(i).setImage1("http://localhost:7777/image/showImage?saveFolder=image1&saveFile=no_img.jpg");
			}
		}
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
		for (int i = 0; i < list.size(); i++) {
			List<TripDto> trips = tripService.list(list.get(i).getPlanNo());
			list.get(i).setTrips(trips);
		}
		return list;
	}

	@GetMapping("/writelist/{userNo}")
	public List<PlanDto> writelist(@PathVariable("userNo") int userNo) throws Exception {
		logger.debug("get most liked list of plan");
		List<PlanDto> list = planService.writelist(userNo);
		return list;
	}

	@GetMapping("/mylikelist/{userNo}")
	public List<PlanDto> mylikelist(@PathVariable("userNo") int userNo) throws Exception {
		logger.debug("get my like list of plan");
		List<PlanDto> list = planService.mylikelist(userNo);
		return list;
	}

	@GetMapping("/watch/{userNo}")
	public List<PlanDto> watchlist(@PathVariable("userNo") int userNo) throws Exception {
		logger.debug("get recently watched list of plan");
		List<PlanDto> list = planService.watch(userNo);
		return list;
	}

	@PostMapping
	public String write(@RequestBody PlanDto planDto) throws Exception {
		logger.debug("**********write plan : {}", planDto);
		if (!(planDto.getTrips()==null) && planDto.getTrips().size()!=0) {
			logger.debug("트립이 있어요?{}",planDto.getTrips().size());
			String image = planDto.getTrips().get(0).getImage1();
			logger.debug("img가 있어요?{}",image);
			planDto.setImg(image);
		}
		planService.write(planDto);
		if (!(planDto.getTrips()==null)) {
			for (TripDto trip : planDto.getTrips()) {
				tripService.write(trip, planDto.getPlanNo());
			}
		}
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
