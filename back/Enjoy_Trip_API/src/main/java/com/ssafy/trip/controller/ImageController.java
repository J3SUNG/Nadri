package com.ssafy.trip.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/image")
public class ImageController {
    @GetMapping("/showImage")
    public ResponseEntity<Resource> showImage(@RequestParam Map<String, String> param) {
        // 사진이 저장된 폴더 경로 변수 선언
        String imageRoot = "";
        String saveFolder = "230521";
        saveFolder = param.get("saveFolder");
//        String originalFile = "test2.png";
        String saveFile = "f7546a53-fe0f-4de6-905f-57bf680deb69.png";
        String saveFile2 = "e1ee1712-b450-4118-9c12-f710fc038c74.png";
        imageRoot = new File("").getAbsolutePath() + "/resources/img/"+saveFolder+"/"+saveFile;
        String imageRoot2 = new File("").getAbsolutePath() + "/resources/img/"+saveFolder+"/"+saveFile2;

        // Resorce를 사용해서 로컬 서버에 저장된 이미지 경로 및 파일 명을 지정
        Resource resource = new FileSystemResource(imageRoot);
        Resource[] res = new Resource[2];
        res[0] = resource;
        res[1] = new FileSystemResource(imageRoot2);
        // 로컬 서버에 저장된 이미지 파일이 없을 경우
        if(!resource.exists()){
            System.out.println("없다.");
            return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND); // 리턴 결과 반환 404
        }

        // 로컬 서버에 저장된 이미지가 있는 경우 로직 처리
        HttpHeaders header = new HttpHeaders();
        Path filePath = null;
        try {
            filePath = Paths.get(imageRoot);
            // 인풋으로 들어온 파일명 .png / .jpg 에 맞게 헤더 타입 설정
            header.add("Content-Type", Files.probeContentType(filePath));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        // 이미지 리턴 실시 [브라우저에서 get 주소 확인 가능] //res를 보낼 순 없음 이미지는 하나씩만
        return new ResponseEntity<Resource>(res[1], header, HttpStatus.OK);
    }
}
