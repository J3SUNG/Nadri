# 나들이

벡앤드 환경 구축

1. STS

   lombok

   - 현재 pom.xml에 이미 추가되어 있음 //pom.xml dependency 추가
   - lombok 설치(sts.exe)
   - STS에서 프로젝트 우클릭 -> maven -> update maven?

   application.properties설정

   - server.port(마음대로)
   - file.url(로컬 환경이면 http://localhost:포트번호 형식)
   - db url(Mysql과 연결, 테이블 이름) 환경에 맞게 설정

2. DB

   - Mysql에 스키마 생성 enjoy_trip
   - DB dump 폴더(last 버전 0525)에 모든 sql 파일 실행
   - 마이페이지에서 최근본... 동작하는지 확인
   - 동작안하고 full group by 오류 발생시,
   - mysql client cmd 관리자권한으로 실행
   - select @@sql_mode 명령어 실행 -> ONLY_FULL... 포함되어있는지 확인
   - 포함되어 있다면
     -> SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));
