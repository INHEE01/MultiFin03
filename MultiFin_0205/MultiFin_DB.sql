create schema multifindb;
-- drop schema multifindb;
use multifindb;

------------------------------------------------
--------------- MEMBER 관련 테이블 ------------------
------------------------------------------------

CREATE TABLE MEMBER (
    mNo      INT  PRIMARY KEY AUTO_INCREMENT,
    ID 		 VARCHAR(30) NOT NULL UNIQUE,
    PASSWORD VARCHAR(100) NOT NULL,
    ROLE 	 VARCHAR(10) DEFAULT 'ROLE_USER',
    NAME 	 VARCHAR(15) NOT NULL,
    PHONE 	 VARCHAR(13),
    EMAIL 	 VARCHAR(100),
    ADDRESS  VARCHAR(100),
    HOBBY 	 VARCHAR(100),
    STATUS 	 VARCHAR(1) DEFAULT 'Y' CHECK(STATUS IN('Y', 'N')),
    ENROLL_DATE DATETIME  DEFAULT CURRENT_TIMESTAMP,
    MODIFY_DATE DATETIME DEFAULT CURRENT_TIMESTAMP
);



INSERT INTO MEMBER (
    mNo, 
    ID, 
    PASSWORD, 
    ROLE,
    NAME, 
    PHONE, 
    EMAIL, 
    ADDRESS, 
    HOBBY, 
    STATUS, 
    ENROLL_DATE, 
    MODIFY_DATE
) VALUES(
    0, 
    'admin', 
    '1234', 
    'ROLE_ADMIN', 
    '관리자', 
    '010-1234-4341', 
    'admin@test.com', 
    '서울시 강남구 역삼동',
    DEFAULT,
    DEFAULT,
    DEFAULT,
    DEFAULT
);

COMMIT;

SELECT * FROM MEMBER;

-------------------------------------------------
--------------- Board 관련 테이블 ------------------
-------------------------------------------------


CREATE TABLE BOARD (	
    bNo INT PRIMARY KEY AUTO_INCREMENT,
    mNo INT, 
	TITLE VARCHAR(1000), 
	CONTENT VARCHAR(2000), 
	TYPE VARCHAR(100), 
	ORIGINAL_FILENAME VARCHAR(100), 
	RENAMED_FILENAME VARCHAR(100), 
	READCOUNT INT DEFAULT 0, 
    STATUS VARCHAR(1) DEFAULT 'Y' CHECK (STATUS IN('Y', 'N')),
    CREATE_DATE DATETIME  DEFAULT CURRENT_TIMESTAMP, 
    MODIFY_DATE DATETIME  DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT FK_BOARD_WRITER FOREIGN KEY(mNo) REFERENCES MEMBER(mNo) ON DELETE SET NULL
);


INSERT INTO BOARD VALUES(0, 1, '[판매] 애플 노트북 팔아요.',  '노트북 맥북 최신입니다. 게임하시면 안됩니다.', 'B1', '원본파일명.txt', '변경된파일명.txt', DEFAULT, 'Y', DEFAULT, DEFAULT);
INSERT INTO BOARD VALUES(0, 1, '[판매] 삼성 노트북 팔아요.',  '삼성 노트북 팝니다. 터치 됩니다.', 'B1', '원본파일명.txt', '변경된파일명.txt', DEFAULT, 'Y', DEFAULT, DEFAULT);
INSERT INTO BOARD VALUES(0, 1, '[판매] 아이폰 팔아요.',  '아이폰13 팝니다. ', 'B1', '원본파일명.txt', '변경된파일명.txt', DEFAULT, 'Y', DEFAULT, DEFAULT);
INSERT INTO BOARD VALUES(0, 1, '[판매] 갤럭시 팔아요.',  '갤럭시 플립3 팝니다. ', 'B1', '원본파일명.txt', '변경된파일명.txt', DEFAULT, 'Y', DEFAULT, DEFAULT);
INSERT INTO BOARD VALUES(0, 1, '[구매] 애플 노트북 삽니다.',  '맥북 게임용으로 삽니다. 이거 게임 잘돌아가나요?', 'B1', '원본파일명.txt', '변경된파일명.txt', DEFAULT, 'Y', DEFAULT, DEFAULT);
INSERT INTO BOARD VALUES(0, 1, '[구매] 삼성 노트북 삽니다.',  '삼성 노트북 삽니다. 아이폰 개발하려 삽니다.', 'B1', '원본파일명.txt', '변경된파일명.txt', DEFAULT, 'Y', DEFAULT, DEFAULT);
INSERT INTO BOARD VALUES(0, 1, '[구매] 아이폰 삽니다.',  '아이폰3사요. 30만원에 네고합니다. ', 'B1', '원본파일명.txt', '변경된파일명.txt', DEFAULT, 'Y', DEFAULT, DEFAULT);
INSERT INTO BOARD VALUES(0, 1, '[구매] 갤럭시 삽니다.',  '갤럭시 삽니다. 아무 기종이나 상관없어요. ', 'B1', '원본파일명.txt', '변경된파일명.txt', DEFAULT, 'Y', DEFAULT, DEFAULT);
INSERT INTO BOARD VALUES(0, 1, '[판매] 애플 노트북 팔아요.',  '노트북 맥북 최신입니다. 게임하시면 안됩니다.', 'B1', '원본파일명.txt', '변경된파일명.txt', DEFAULT, 'Y', DEFAULT, DEFAULT);
INSERT INTO BOARD VALUES(0, 1, '[판매] 삼성 노트북 팔아요.',  '삼성 노트북 팝니다. 터치 됩니다.', 'B1', '원본파일명.txt', '변경된파일명.txt', DEFAULT, 'Y', DEFAULT, DEFAULT);
INSERT INTO BOARD VALUES(0, 1, '[판매] 아이폰 팔아요.',  '아이폰13 팝니다. ', 'B1', '원본파일명.txt', '변경된파일명.txt', DEFAULT, 'Y', DEFAULT, DEFAULT);
INSERT INTO BOARD VALUES(0, 1, '[판매] 갤럭시 팔아요.',  '갤럭시 플립3 팝니다. ', 'B1', '원본파일명.txt', '변경된파일명.txt', DEFAULT, 'Y', DEFAULT, DEFAULT);
INSERT INTO BOARD VALUES(0, 1, '[구매] 애플 노트북 삽니다.',  '맥북 게임용으로 삽니다. 이거 게임 잘돌아가나요?', 'B1', '원본파일명.txt', '변경된파일명.txt', DEFAULT, 'Y', DEFAULT, DEFAULT);
INSERT INTO BOARD VALUES(0, 1, '[구매] 삼성 노트북 삽니다.',  '삼성 노트북 삽니다. 아이폰 개발하려 삽니다.', 'B1', '원본파일명.txt', '변경된파일명.txt', DEFAULT, 'Y', DEFAULT, DEFAULT);
INSERT INTO BOARD VALUES(0, 1, '[구매] 아이폰 삽니다.',  '아이폰3사요. 30만원에 네고합니다. ', 'B1', '원본파일명.txt', '변경된파일명.txt', DEFAULT, 'Y', DEFAULT, DEFAULT);
INSERT INTO BOARD VALUES(0, 1, '[구매] 갤럭시 삽니다.',  '갤럭시 삽니다. 아무 기종이나 상관없어요. ', 'B1', '원본파일명.txt', '변경된파일명.txt', DEFAULT, 'Y', DEFAULT, DEFAULT);
INSERT INTO BOARD VALUES(0, 1, '[판매] 애플 노트북 팔아요.',  '노트북 맥북 최신입니다. 게임하시면 안됩니다.', 'B1', '원본파일명.txt', '변경된파일명.txt', DEFAULT, 'Y', DEFAULT, DEFAULT);
INSERT INTO BOARD VALUES(0, 1, '[판매] 삼성 노트북 팔아요.',  '삼성 노트북 팝니다. 터치 됩니다.', 'B1', '원본파일명.txt', '변경된파일명.txt', DEFAULT, 'Y', DEFAULT, DEFAULT);
INSERT INTO BOARD VALUES(0, 1, '[판매] 아이폰 팔아요.',  '아이폰13 팝니다. ', 'B1', '원본파일명.txt', '변경된파일명.txt', DEFAULT, 'Y', DEFAULT, DEFAULT);
INSERT INTO BOARD VALUES(0, 1, '[판매] 갤럭시 팔아요.',  '갤럭시 플립3 팝니다. ', 'B1', '원본파일명.txt', '변경된파일명.txt', DEFAULT, 'Y', DEFAULT, DEFAULT);
INSERT INTO BOARD VALUES(0, 1, '[구매] 애플 노트북 삽니다.',  '맥북 게임용으로 삽니다. 이거 게임 잘돌아가나요?', 'B1', '원본파일명.txt', '변경된파일명.txt', DEFAULT, 'Y', DEFAULT, DEFAULT);
INSERT INTO BOARD VALUES(0, 1, '[구매] 삼성 노트북 삽니다.',  '삼성 노트북 삽니다. 아이폰 개발하려 삽니다.', 'B1', '원본파일명.txt', '변경된파일명.txt', DEFAULT, 'Y', DEFAULT, DEFAULT);
INSERT INTO BOARD VALUES(0, 1, '[구매] 아이폰 삽니다.',  '아이폰3사요. 30만원에 네고합니다. ', 'B1', '원본파일명.txt', '변경된파일명.txt', DEFAULT, 'Y', DEFAULT, DEFAULT);
INSERT INTO BOARD VALUES(0, 1, '[구매] 갤럭시 삽니다.',  '갤럭시 삽니다. 아무 기종이나 상관없어요. ', 'B1', null, null, DEFAULT, 'Y', DEFAULT, DEFAULT);



COMMIT;
SELECT * FROM BOARD;

------------------------------------------------------------------
------------------------- REPLY 관련 테이블 -------------------------
------------------------------------------------------------------


CREATE TABLE REPLY(
  rNo INT PRIMARY KEY AUTO_INCREMENT,
  bNo INT,
  mNo INT,
  CONTENT VARCHAR(1000),
  STATUS VARCHAR(1) DEFAULT 'Y' CHECK (STATUS IN ('Y', 'N')),
  CREATE_DATE DATETIME DEFAULT CURRENT_TIMESTAMP,
  MODIFY_DATE DATETIME DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (bNo) REFERENCES BOARD(bNo),
  FOREIGN KEY (mNo) REFERENCES MEMBER(mNo)
);



INSERT INTO REPLY VALUES(0, 1, 1, '안녕하세요.', DEFAULT, DEFAULT, DEFAULT);
INSERT INTO REPLY VALUES(0, 1, 1, '반갑습니다.', DEFAULT, DEFAULT, DEFAULT);
INSERT INTO REPLY VALUES(0, 1, 1, '아이폰 좋나요?', DEFAULT, DEFAULT, DEFAULT);
INSERT INTO REPLY VALUES(0, 1, 1, '갤럭시 좋나요?', DEFAULT, DEFAULT, DEFAULT);
INSERT INTO REPLY VALUES(0, 2, 1, '안녕하세요.', DEFAULT, DEFAULT, DEFAULT);
INSERT INTO REPLY VALUES(0, 2, 1, '반갑습니다.', DEFAULT, DEFAULT, DEFAULT);
INSERT INTO REPLY VALUES(0, 2, 1, '아이폰 좋나요?', DEFAULT, DEFAULT, DEFAULT);
INSERT INTO REPLY VALUES(0, 2, 1, '갤럭시 좋나요?', DEFAULT, DEFAULT, DEFAULT);
INSERT INTO REPLY VALUES(0, 3, 1, '안녕하세요.', DEFAULT, DEFAULT, DEFAULT);
INSERT INTO REPLY VALUES(0, 3, 1, '반갑습니다.', DEFAULT, DEFAULT, DEFAULT);
INSERT INTO REPLY VALUES(0, 3, 1, '아이폰 좋나요?', DEFAULT, DEFAULT, DEFAULT);
INSERT INTO REPLY VALUES(0, 3, 1, '갤럭시 좋나요?', DEFAULT, DEFAULT, DEFAULT);


COMMIT;

SELECT * FROM REPLY;


-- -----------------------------
-- 	증권 정보 --------------------
-- -----------------------------


-- 환율 정보 (환율 확인할 때 필요)
-- drop table exchangeRate;
create table exchangeRate(
	 rno int auto_increment, -- 일련번호
     recorddate DATETIME, -- 기준일
	 cur_unit varchar(13), -- 통화코드
	 ttb varchar(13), -- 전신환(송금)받으실때
	 tts varchar(13),  -- 전신환(송금)보내실때
	 deal_bas_r varchar(13), -- 매매 기준율
	 bkpr varchar(13), -- 장부가격
	 yy_efee_r varchar(13),  -- 년환가료율
	 ten_dd_efee_r varchar(13), -- 10일환가료율
	 kftc_bkpr varchar(13), -- 서울외국환중개 매매기준율
	 kftc_deal_bas_r varchar(13), -- 서울외국환중개 장부가격
	 cur_nm varchar(20), -- 국가/통화명
     
     primary key (rno)
);

select * from exchangeRate; -- exchangeRate (환율 정보) 정보 테이블의 모든 Attribute 검색

-- [증권] 금융위원회_주식 시세 정보
-- drop table stockprice;
create table StockPrice (
	sno int auto_increment, -- 일련번호
	basDt DATETIME, -- 기준일. 기준 일자 
	srtnCd int, -- 단축코드
	isinCd int, -- 국제 채권 식별 번호
	itmsNm varchar(30), -- 종목의 명칭
	mrktCtg varchar(6), -- 주식의 시장 구분 (KOSPI/KOSDAQ/KONEX 중 1)
	clpr varchar(11), -- 정규시장의 매매시간 종료시까지 형성되는 최종가격
	vs varchar(11), -- 전일 대비 등락
	fltRt varchar(11), -- 전일 대비 등락에 따른 비율
	mkp int, -- 정규시장의 매매시간 개시 후 형성되는 최초가격
	hipr int, -- 하루 중 가격의 최고치
	lopr int, -- 하루 중 가격의 최저치
	trqu int,  -- 거래량. 체결수량의 누적 합계
	trPrc bigint, -- 거래대금
	lstgStCnt bigint,  -- 상장주식수
	mrktTotAmt bigint,  -- 시가총액
    
    primary key (sno)
);
select * from stockprice;
select * from stockprice where itmsNm='헝셩그룹';
select count(*) from stockprice;

-- [증권] 금융위원회_주식 배당 정보
-- drop table stockdiviinfo;
create table Stockdiviinfo (
	sdno int primary key auto_increment, -- 일련번호 
    sno int,
	basDt Date, 
    cashDvdnPayDt Date,
    cashGrdnDvdnRt varchar(100),
    crno varchar(100),
    dvdnBasDt Date,
    isinCd varchar(100),
    isinCdNm varchar(100),
    scrsItmsKcd varchar(100),
    scrsItmsKcdNm varchar(100),
    stckDvdnRcd varchar(100),
    stckDvdnRcdNm varchar(100),
    stckGenrCashDvdnRt varchar(100),
    stckGenrDvdnAmt varchar(100),
    stckGenrDvdnRt varchar(100),
    stckGrdnDvdnAmt varchar(100),
    stckGrdnDvdnRt varchar(100),
    stckHndvDt Date,
    stckIssuCmpyNm varchar(100),
    stckParPrc varchar(100),
    stckStacMd varchar(100),
    trsnmDptyDcd varchar(100),
    trsnmDptyDcdNm varchar(100),
    
    foreign key (sno) references stockprice(sno)
);
select * from stockdiviinfo;

-- 금융위원회_주식 발행 정보
-- drop table stockissustat;
create table StocIssuStat (
	sisno int primary key auto_increment, -- 일련번호
    sno int,
    basDt DATETIME,
    crno bigint,
    onskTisuCnt bigint,
    pfstTisuCnt int, 
    stckIssuCmpyNm varchar(100),
    
    foreign key (sno) references stockprice(sno)
);
select * from StocIssuStat;

-- 금융위원회_펀드상품기본정보
-- drop table FundProductInfo;
create table FundProductInfo(
	fpino int primary key auto_increment, -- 일련번호
	basDt DATETIME, -- 기준일자
    srtnCd varchar(30), -- 단축코드
    fndNm varchar(100), -- 펀드명
    ctg varchar(10), -- 구분
    setpDt DATETIME, -- 설정일 (펀드의 탄생일)
    fndTp varchar(10), -- 펀드유형
	prdClsfCd varchar(30), -- 상품분류코드
	asoStdCd varchar(30) -- 협회표준코드
);
select * from fundProductInfo;

CREATE TABLE stockPriceIndex(
   stock_type VARCHAR(1000), -- 타입
   stock_date DATETIME, -- 날짜
    fin VARCHAR(10000),  -- 종가
   open VARCHAR(1000), -- 오픈가
   highLevel VARCHAR(1000), -- 고가
   lowLevel VARCHAR(1000), -- 저가
   trading_volume VARCHAR(100), -- 거래량
   change_percent VARCHAR(1000) -- 변동
);
SELECT * FROM stockPriceIndex;

-- -----------------------------
-- 	은행 정보 --------------------
-- -----------------------------


-- 금융감독원 금융회사개요 API
-- drop table bankcompany;
create table BankCompany (
	bankCompanyNo int primary key auto_increment,
	dcls_month varchar(6), -- 공시 제출월 [YYYYMM]
	fin_co_no varchar(10), -- 금융회사코드
	kor_co_nm varchar(30), -- 금융회사 명
	dcls_chrg_man varchar(100), -- 공시담당자
	homp_url varchar(200), -- 홈페이지주소
	cal_tel varchar(13), -- 콜센터전화번호
	area_cd int, -- 지역구분 | 01~17	
	area_nm varchar(2), -- 지역이름 | 서울, 부산, 대구, 인천, 광주, 대전, 울산, 세종, 경기, 강원, 충북, 충남, 전북, 전남, 경북, 경남, 제주
	exis_yn char(1) -- 점포소재여부
);
select * from bankcompany;

-- 금융감독원 정기예금 API
-- drop table bankdeposit;
create table BankDeposit (
	bankDepositNo int primary key auto_increment, -- 일련번호
	dcls_month varchar(6), -- 공시 제출월 [YYYYMM]
	fin_co_no varchar(10), -- 금융회사 코드
	kor_co_nm varchar(20), -- 금융회사명
	fin_prdt_cd varchar(100), -- 금융상품 코드
	fin_prdt_nm varchar(100), -- 금융 상품명
	join_way varchar(100), -- 가입 방법
	mtrt_int varchar(300), -- 만기 후 이자율
	spcl_cnd varchar(300), -- 우대조건
	join_deny char(1), -- 가입제한 Ex) 1:제한없음, 2:서민전용, 3:일부제한"
	join_member varchar(100), -- 가입대상
	etc_note varchar(300), -- 기타 유의사항
	max_limit bigint, -- 최고한도
	dcls_strt_day DATETIME, -- 공시 시작일
	dcls_end_day varchar(11), -- 공시 종료일
	fin_co_subm_day DATETIME, -- 금융회사 제출일 [YYYYMMDDHH24MI]

	intr_rate_type char(1), -- 저축 금리 유형
	intr_rate_type_nm varchar(5), -- 저축 금리 유형명
	save_trm varchar(3), -- 저축 기간 [단위: 개월]
	intr_rate bigint, -- 저축 금리 [소수점 2자리]
	intr_rate2 bigint -- 최고 우대금리 [소수점 2자리]
);
select * from bankdeposit;
select count(*) as '총 개수' from bankDeposit;

-- 금융감독원 적금 API
-- drop table BankSaving;
create table BankSaving (
	bankSavingNo int primary key auto_increment, -- 일련번호
	dcls_month varchar(6), -- 공시 제출월 [YYYYMM]
	fin_co_no varchar(10), -- 금융회사 코드
	kor_co_nm varchar(50), -- 금융회사명
	fin_prdt_cd varchar(50), -- 금융상품 코드
	fin_prdt_nm varchar(100), -- 금융 상품명
	join_way varchar(300), --  가입 방법
	mtrt_int varchar(300), --  만기 후 이자율
	spcl_cnd varchar(300), -- 우대조건
	join_deny char(1), --  가입제한 Ex) 1:제한없음, 2:서민전용, 3:일부제한"
	join_member varchar(300), --  가입대상
	etc_note varchar(300), --  기타 유의사항
	max_limit bigint, -- 최고한도
	dcls_strt_day DATETIME, --  공시 시작일
	dcls_end_day varchar(30), -- 공시 종료일
	fin_co_subm_day DATETIME, -- 금융회사 제출일 [YYYYMMDDHH24MI]

	intr_rate_type varchar(5), -- 저축 금리 유형	 
	intr_rate_type_nm varchar(5), --  저축 금리 유형명
	rsrv_type char(1), -- 적립 유형
	rsrv_type_nm varchar(5), --  적립 유형명
	save_trm varchar(3), --  저축 기간 [단위: 개월]
	intr_rate int, -- 저축 금리 [소수점 2자리] 
	intr_rate2 int -- 최고 우대금리 [소수점 2자리]
);
select * from bankSaving;

-- [은행] 개인신용대출상품
-- drop table loanCredit;
create table loanCredit(
	loanCreditNo int primary key auto_increment, -- 일련번호
	dcls_month varchar(6),	-- 공시 제출월 [YYYYMM]
	fin_co_no varchar(10),	-- 금융회사코드
	kor_co_nm varchar(50),	-- 금융회사 명
	fin_prdt_cd varchar(50),	-- 금융상품코드
	fin_prdt_nm varchar(100),	-- 금융상품명
	join_way varchar(300),	-- 가입방법
	crdt_prdt_type varchar(10),	-- 	대출종류 코드
	crdt_prdt_type_nm varchar(100),	-- 	대출종류명	
	cb_name varchar(50), 	-- 	CB 회사명
	dcls_strt_day DATETIME,	-- 공시 시작일
	dcls_end_day varchar(13),	-- 공시 종료일
	fin_co_subm_day DATETIME,	-- 금융회사 제출일 [YYYYMMDDHH24MI]
    
	crdt_lend_rate_type char(1),	-- 금리구분 코드
	crdt_lend_rate_type_nm varchar(10), 	-- 금리구분
	crdt_grad_1 float,	-- 900점 초과 [소수점 2자리]
	crdt_grad_4 decimal(5, 2),	-- 801~900점 [소수점 2자리]
	crdt_grad_5 decimal(5, 2),	-- 701~800점 [소수점 2자리]
	crdt_grad_6 decimal(5, 2),	-- 601~700점 [소수점 2자리]
	crdt_grad_avg decimal(5, 2)	-- 평균 금리 [소수점 2자리]
);
select * from loancredit;

-- [은행] 금융감독원 주택담보대출
-- drop table loanmortgage;
create table LoanMortgage (
	loanMortgageNo int primary key auto_increment, -- 일련번호
	dcls_month varchar(10), -- 공시 제출월 [YYYYMM]
	fin_co_no varchar(10),	-- 금융회사코드
	kor_co_nm varchar(50),	-- 금융회사 명
	fin_prdt_cd varchar(20),	-- 금융상품코드
	fin_prdt_nm varchar(100),	-- 금융상품명
	join_way varchar(300),	-- 가입방법
    loan_inci_expn varchar(300),	-- 대출 부대비용
    erly_rpay_fee varchar(300),	-- 중도상환 수수료
    dly_rate varchar(300),	-- 연체 이자율
    loan_lmt varchar(100),	-- 대출한도
	dcls_strt_day DATETIME,	-- 공시 시작일
	dcls_end_day varchar(13),	-- 공시 종료일
	fin_co_subm_day DATETIME,	-- 금융회사 제출일 [YYYYMMDDHH24MI]

	mrtg_type varchar(1),	-- 담보유형 코드
	mrtg_type_nm varchar(10),	-- 담보유형
	rpay_type varchar(1),	-- 대출상환유형 코드
	rpay_type_nm varchar(10),	-- 대출상환유형**
	lend_rate_type varchar(1),	-- 대출금리유형 코드
	lend_rate_type_nm varchar(10),	-- 대출금리유형
	lend_rate_min decimal(5, 2),	-- 대출금리_최저 [소수점 2자리]
	lend_rate_max decimal(5, 2),	-- 대출금리_최고 [소수점 2자리]
	lend_rate_avg decimal(5, 2)	-- 전월 취급 평균금리 [소수점 2자리]
);
select * from loanMortgage;

-- 금융감독원 전세자금대출 API
-- drop table loanRentHouse;
create table LoanRentHouse (
	loanRentHouseNo int primary key auto_increment, -- 일련번호
	dcls_month varchar(10), -- 공시 제출월 [YYYYMM]
	fin_co_no varchar(10), -- 금융회사 코드
	kor_co_nm varchar(50), -- 금융회사 명
	fin_prdt_cd varchar(20), -- 금융상품 코드
	fin_prdt_nm varchar(50), -- 금융상품명
	join_way varchar(100), -- 가입방법
	loan_inci_expn varchar(300), -- 대출 부대비용
	erly_rpay_fee varchar(300), -- 중도상환 수수료
	dly_rate varchar(300), -- 연체 이자율
	loan_lmt varchar(100), -- 대출한도
	dcls_strt_day DATETIME,	-- 공시 시작일
	dcls_end_day varchar(13), -- 공시 종료일
	fin_co_subm_day DATETIME, -- 금융회사 제출일
    
	rpay_type varchar(1), -- 대출상환유형 코드
	rpay_type_nm varchar(10), -- 대출상환유형**
	lend_rate_type varchar(1), -- 대출금리유형 코드
	lend_rate_type_nm varchar(10), -- 대출금리유형
	lend_rate_min decimal(5, 2), -- 대출금리_최저 [소수점 2자리]
	lend_rate_max decimal(5, 2), -- 대출금리_최고 [소수점 2자리]
	lend_rate_avg decimal(5, 2) -- 전월 취급 평균금리 [소수점 2자리]
);
select * from loanRentHouse;
select count(*) from loanRentHouse;

-- ----------------------------------------------
-- ------------- 신용카드 테이블 ------------------
-- ----------------------------------------------
DROP TABLE IF EXISTS DEBITCARD;
CREATE TABLE DEBITCARD(
	COMPANY_IMG VARCHAR(1000), -- 카드사 LOGO
	COMPANY_NM VARCHAR(1000), -- 카드사명
	PRODUCT_IMG VARCHAR(1000), -- 상품이미지URL
	PRODUCT_NM VARCHAR(100), -- 상품명
	PRODUCT_CHAR VARCHAR(100), -- 상품특징
	KEY_BENEFIT VARCHAR(1000), -- 주요혜택
	DETAIL_URL VARCHAR(1000) -- 상세정보URL
);

INSERT INTO DEBITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-lotte.jpg', '롯데카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=%EB%A1%9C%EC%B9%B4%ED%81%B4%EB%9E%98%EC%8B%9D[20220718162432112].png&fileType=carddamoa', 'LOCA CLASSIC 카드', '전가맹점 최대 1% 할인', '전가맹점 최대 1% 할인<br>※ LOCA for/in 카드와 Set로 이용 시 혜택과 실적이 합산', 'https://www.lottecard.co.kr/app/LPCDXAA_V001.lc?vtCdKndC=P13379-A13379'); 
INSERT INTO DEBITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-lotte.jpg', '롯데카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=%EB%A1%9C%EC%B9%B4%EB%A8%B8%EB%8B%88[20220718162650308].png&fileType=carddamoa', 'LOCA MONEY 카드', '전가맹점 최대 2% 로카코인 적립', '한도제한 없이 전가맹점 최대 2% 로카코인 적립', 'https://www.lottecard.co.kr/app/LPCDADB_V100.lc?vtCdKndC=P13561-A13561'); 
INSERT INTO DEBITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-lotte.jpg', '롯데카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=1.2[20220718162749698].png&fileType=carddamoa', 'LOCA LIKIT 1.2 카드', '조건없이 전가맹점 1.2% 할인', '실적조건, 한도제한 없이 전가맹점 1.2% 할인/온라인 1.5% 할인', 'https://www.lottecard.co.kr/app/LPCDADB_V100.lc?vtCdKndC=P13937-A13937'); 
INSERT INTO DEBITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-bc.jpg', '비씨카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=4._KT_SUPER_%EC%B9%B4%EB%93%9C_%ED%8E%98%EC%8A%A4%ED%8B%B0%EB%B2%8C[20221006101940571].png&fileType=carddamoa', 'KT 바로 Super카드', '월 최대 25,000원 통신요금 할인', 'KT통신요금 할인<br>
- Super카드 월 최대 18,000원, Super+카드 월 최대 25,000원<br>
SK주유소 할인 : 1% 청구할인', 'https://www.bccard.com/app/card/CreditCardMain.do?gdsno=101915'); 
INSERT INTO DEBITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-bc.jpg', '비씨카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=5._%EC%8B%9C%EB%B0%9C%EC%B9%B4%EB%93%9C_%EC%82%AC%EC%A7%81%EC%84%9C[20221006112140096].png&fileType=carddamoa', '始發(시발)카드', '선넘는 특별할인', '주요 사용처 매출금액별 180/1800원 차등 청구 할인<br>
일반 사용처 실적, 한도 조건없이 0.7% 청구 할인', 'https://www.bccard.com/app/card/CreditCardMain.do?gdsno=101514'); 
INSERT INTO DEBITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-bc.jpg', '비씨카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=3._%EB%A6%AC%EC%9B%8C%EB%93%9C%ED%94%8C%EB%9F%AC%EC%8A%A4%EC%B9%B4%EB%93%9C[20221006102457293].png&fileType=carddamoa', '바로 리워드 플러스카드', '국내외 전 가맹점 최대 1.5% 적립', '국내외 모든 가맹점 전월 실적에 따라 0.5%~1.5% 적립<br>
쇼핑,엔터테인먼트 등 5%~30% 적립', 'https://www.bccard.com/app/card/CreditCardMain.do?gdsno=101921'); 
INSERT INTO DEBITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-samsung.jpg', '삼성카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=iD_ON_%ED%8E%91%ED%82%A4_80by50%ED%94%BD%EC%85%80[20211123135251421].jpg&fileType=carddamoa', '삼성 iD ON 카드', '내 취향을 알아서,
많이 쓰는 곳에선 더 큰 혜택 제공', '커피전문점, 배달앱, 델리 중 1개영역 30%할인<br>
교통 · 이동통신 · 스트리밍 10% 할인<br>
온라인 간편결제 · 해외 최대 3% 할인', 'https://www.samsungcard.com/personal/card/cardfinder/UHPPCA0102M0.jsp?code=AAP1731'); 
INSERT INTO DEBITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-samsung.jpg', '삼성카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=D17964M1_D17963M1_taptap_O_copy[20170120111720886].jpg&fileType=carddamoa', '삼성카드 taptap O', '직접 선택하는 혜택,
탭탭 옵션형!', '쇼핑 업종 7% 결제일할인 또는 1% 빅포인트 적립,<br>
커피 업종 30% 또는 50% 결제일할인(옵션)<br>
대중교통/택시/이동통신 10%, CGV 및 롯데시네마 5,000원 결제일할인', 'https://www.samsungcard.com/personal/card/cardfinder/UHPPCA0102M0.jsp?code=AAP1483'); 
INSERT INTO DEBITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-samsung.jpg', '삼성카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=D17886A1_%EC%95%A4MILEAGE_%ED%94%8C%EB%9E%98%ED%8B%B0%EB%8A%84_%EC%8A%A4%EC%B9%B4%EC%9D%B4%ED%8C%A8%EC%8A%A4_copy[20170120111902058].jpg&fileType=carddamoa', '삼성카드 & MILEAGE PLATINUM (스카이패스)', '더욱 강력한
스카이패스 마일리지 혜택', '모든 가맹점 이용금액 1,000원당 스카이패스 1마일리지 적립<br>
백화점ㆍ주유ㆍ커피ㆍ편의점ㆍ택시 이용금액 1,000원당 스카이패스 2마일리지 적립<br>
인천공항 마티나 라운지ㆍ발렛파킹 무료', 'https://www.samsungcard.com/personal/card/cardfinder/UHPPCA0102M0.jsp?code=AAP1452'); 
INSERT INTO DEBITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-shinhan.jpg', '신한카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=Deep_Dream[20171117151833114].jpg&fileType=carddamoa', '신한카드 Deep Dream', '한도없이 0.7% 적립, 많이 쓴 곳 5배 자동 적립', '전월실적 제한 및 적립한도 없이 기본 0.7% 적립<br>
자주 가는 DREAM 영역 기본의 3배(2.1%) 적립<br>
가장 많이 쓴 DREAM 영역 기본의 5배(3.5%) 자동 적립', 'https://www.shinhancard.com/conts/person/card_info/major/benefit/large/1445316_12904.jsp'); 
INSERT INTO DEBITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-shinhan.jpg', '신한카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=Air_1.5[20171117175423282].jpg&fileType=carddamoa', '아시아나 신한카드 Air 1.5', '1.5배 높은 아시아나 마일리지 적립카드', '국내/해외 가맹점 1,000원당 1.5 마일리지 적립<br>
해외 이용금액 더블 적립(월 2천마일 한도)<br>
공항라운지, 호텔/공항 발렛파킹 무료서비스(Master 브랜드)', 'https://www.shinhancard.com/conts/person/card_info/major/benefit/go/1366616_12892.jsp'); 
INSERT INTO DEBITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-shinhan.jpg', '신한카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=Edu[20171117175940943].jpg&fileType=carddamoa', '신한카드 Edu', '학부모를 위한 교육비와 아파트 관리비 캐시백 카드', '학원/학습지/유치원 업종 5~10% 캐시백<br>
교육비 납부 건수에 따른 추가 캐시백<br>
교육비 결제 및 아파트 관리비 결제 동시 충족 시 5천원 캐시백', 'https://www.shinhancard.com/conts/person/card_info/major/benefit/buy/1344979_12895.jsp'); 
INSERT INTO DEBITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-woori.jpg', '우리카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=NU_Uniq_(158x250)[20230111112445406].png&fileType=carddamoa', 'NU Uniq', '나를 위한 UNIQ한 선택', 'LIVING/ENJOY 영역 1.5~5% 할인<br>
UNIQ LIVING 가장 많이 이용한 영역 1.5% 한번 더 적립<br>
국내 가맹점 최대 0.8% 할인', 'https://pc.wooricard.com/dcpc/yh1/crd/crd01/H1CRD101S02.do?cdPrdCd=101886'); 
INSERT INTO DEBITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-woori.jpg', '우리카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=NU_Uniq_Point(250x158)[20230111112516303].png&fileType=carddamoa', 'NU Uniq Point', '나를 위한 UNIQ한 선택', '국내 가맹점 0.5% 적립<br>
S.T.Y.L.E 가맹점 2.0% 적립 & 한번 더 적립<br>
주유/충전 리터(ℓ)당 60점 적립', 'https://pc.wooricard.com/dcpc/yh1/crd/crd01/H1CRD101S02.do?cdPrdCd=101588'); 
INSERT INTO DEBITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-woori.jpg', '우리카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=NU_IU_(158x250)[20230111152445941].png&fileType=carddamoa', 'NU I&U', '초심플하게 할인에 초집중', '국내 가맹점 1%~0.7% 청구 할인<br>
주유 리터당 60~100원 청구 할인<br>
대중교통, 커피 10% 청구 할인', 'https://pc.wooricard.com/dcpc/yh1/crd/crd01/H1CRD101S02.do?cdPrdCd=102245'); 
INSERT INTO DEBITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-hana.jpg', '하나카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=MULTI_Any[20210604101434164].png&fileType=carddamoa', 'Multi Any 모바일 카드', '전가맹점 어디서나 0.7% 적립,페이결제 1% 적립', '- 국내외 전가맹점 0.7% / 페이결제 1%(월 적립한도 없음)<br>
- 3대마트,SSM,백화점 2% / 딜리버리 3% / 대중교통 4% 하나머니 적립(월 통합 5만 하나머니 까지)', 'https://www.hanacard.co.kr/OPI41000000D.web?schID=pcd&CD_PD_SEQ=12958'); 
INSERT INTO DEBITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-hana.jpg', '하나카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=MULTI_On[20210604102015803].png&fileType=carddamoa', 'Multi On 모바일 카드', '전가맹점 어디서나 0.7%/페이결제 1% 적립,디지털혜택까지', '- 국내외 전가맹점 0.7% / 페이결제 1%(월 적립한도 없음)<br>
- 온라인쇼핑 2% / 딜리버리 3% / 디지털구독 4% 하나머니 적립(월 통합 5만 하나머니 까지)', 'https://www.hanacard.co.kr/OPI41000000D.web?schID=pcd&CD_PD_SEQ=12934'); 
INSERT INTO DEBITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-hana.jpg', '하나카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=MULTI_Living[20210604102716619].png&fileType=carddamoa', 'Multi Living 모바일 카드', '주중 온라인 쇼핑과 마트에서 10%
주말 주유소와 백화점에서 10% 할인', '-(주중)온라인쇼핑,마트 10% 할인(월3만원 한도)<br>
-(주말)주유,백화점 10% 할인(월 3만원 한도)<br>
-자동이체 5%, 페이결제 1% 할인(각 5천원 한도)', 'https://www.hanacard.co.kr/OPI41000000D.web?schID=pcd&CD_PD_SEQ=12900'); 
INSERT INTO DEBITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-hyundai.jpg', '현대카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=card_M_BOOST[20210113102917403].png&fileType=carddamoa', '현대카드 M BOOST', '현대카드 대표 포인트 카드', '업종별 0.5~3% M포인트 적립<br>
온라인 간편결제서비스, 해외 가맹점 5% 적립<br>
보너스 리워드 1만 M포인트 적립', 'https://www.hyundaicard.com/cpc/cr/CPCCR0201_01.hc?cardWcd=MBT'); 
INSERT INTO DEBITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-hyundai.jpg', '현대카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=card_X_BOOST[20210113103030971].png&fileType=carddamoa', '현대카드 X BOOST', '현대카드 대표 할인카드', '국내외 가맹점에서 1%/1.5%할인<br>
온라인 간편결제서비스, 해외 가맹점 5% 할인<br>
모든 가맹점 2~3개월 무이자 할부', 'https://www.hyundaicard.com/cpc/cr/CPCCR0201_01.hc?cardflag=C&cardWcd=XE3'); 
INSERT INTO DEBITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-hyundai.jpg', '현대카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=02743_V_BA_F[20200601164135556].png&fileType=carddamoa', '현대카드ZERO Edition2(할인형)', '실적 조건 없고, 할인 한도도 없는 카드', '국내외 가맹점 0.7% 청구 할인<br>
생활 필수 영역 1.5% 청구 할인<br>
모든 가맹점 2~3개월 무이자 할부', 'https://www.hyundaicard.com/cpc/cr/CPCCR0201_01.hc?cardflag=C&cardWcd=ZROE2'); 
INSERT INTO DEBITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-kb.jpg', '국민카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=%EC%9D%B4%EC%A7%80%ED%94%BD%EC%B9%B4%EB%93%9C[20190808112936294].JPG&fileType=carddamoa', 'Easy pick카드', '주요 생활 영역 적립 + 선택 영역 적립', '인터넷쇼핑몰, 대형마트, 주유 5% 적립, 선호영역(택1) 5% 적립, 교통,이동통신 5% 적립', 'https://card.kbcard.com/CXPRICAC0076.cms?mainCC=a&cooperationcode=09243'); 
INSERT INTO DEBITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-kb.jpg', '국민카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=hhhhhh[20171116181359231].png&fileType=carddamoa', 'H.Point KB국민카드', '현대백화점그룹 멤버십 혜택에 KB국민카드 혜택을 더하다!', 'H.Point 최대 1.5% 적립 / 3대 생활영역 1~2만원 청구할인 / 맥스무비 영화예매 시 3,500원 할인 / 롯데월드, 에버랜드, 캐리비안베이 30~50% 청구할인', 'https://card.kbcard.com/CXPRICAC0076.cms?mainCC=a&cooperationcode=04415'); 
INSERT INTO DEBITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-kb.jpg', '국민카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=Easy_fly_%ED%8B%B0%ED%83%80%EB%8A%84%EC%B9%B4%EB%93%9C_%EC%B9%B4%EB%93%9C%ED%94%8C%EB%A0%88%EC%9D%B4%ED%8A%B8_%EB%94%94%EC%9E%90%EC%9D%B8[20190813181220085].jpg&fileType=carddamoa', 'KB국민 Easy fly 티타늄카드', '저비용항공사(LCC) 할인 + 여행 할인', '저비용항공사(LCC) 항공권 5% 할인, 유료부가서비스 건당 1만원 할인, 면세점/호텔/숙박 5% 할인', 'https://card.kbcard.com/CXPRICAC0076.cms?mainCC=a&cooperationcode=09245'); 

SELECT * FROM DEBITCARD;
SELECT COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL
FROM DEBITCARD;
SELECT COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL
FROM DEBITCARD
WHERE COMPANY_NM='롯데카드';
-- ----------------------------------------------
-- ------------- 신용카드 테이블 ------------------
-- ----------------------------------------------
DROP TABLE IF EXISTS CREDITCARD;
CREATE TABLE CREDITCARD(
	COMPANY_IMG VARCHAR(1000), -- 카드사 LOGO
	COMPANY_NM VARCHAR(1000), -- 카드사명
	PRODUCT_IMG VARCHAR(1000), -- 상품이미지URL
	PRODUCT_NM VARCHAR(100), -- 상품명
	PRODUCT_CHAR VARCHAR(100), -- 상품특징
	KEY_BENEFIT VARCHAR(1000), -- 주요혜택
	DETAIL_URL VARCHAR(1000) -- 상세정보URL
);

  INSERT INTO CREDITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-lotte.jpg', '롯데카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=%ED%8F%AC%EC%9D%B8%ED%8A%B8%ED%94%8C%EB%9F%AC%EC%8A%A4%EC%B2%B4%ED%81%AC[20170118183638503].png&fileType=carddamoa', '롯데 포인트플러스 체크카드', '더블 포인트 적립 서비스', 'L.POINT 제휴사에서 결제 시 제휴사 현장에서 적립받은 L.POINT를 한 번 더 적립!', 'https://www.lottecard.co.kr/app/IHCDAAA_V200.do?vt_cd_knd_c=C00284-A00284#none');  
  INSERT INTO CREDITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-lotte.jpg', '롯데카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=%EC%9C%84%ED%81%B4%EB%A6%AC%EC%B2%B4%ED%81%AC%EC%B9%B4%EB%93%9C[20170118184303691].png&fileType=carddamoa', '위클리 체크카드', '평일(월~금) 이용실적으로 주말(토~일) 캐시백 혜택', '평일(5~10만원 미만) : 주말이용실적의 0.5% 캐시백<br>
평일(10~20만원 미만) : 주말이용실적의 1% 캐시백<br>
평일(20만원 이상) : 주말이용실적의 2% 캐시백', 'https://www.lottecard.co.kr/app/IHCDAAA_V200.do?vt_cd_knd_c=C10343-B10347');  
  INSERT INTO CREDITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-lotte.jpg', '롯데카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=%EB%9D%BC%EC%9D%B4%ED%82%B7%EC%98%A8_%EC%B2%B4%ED%81%AC%ED%94%8C%EB%9F%AC%EC%8A%A4[20220718170957700].JPG&fileType=carddamoa', 'LIKIT ON 체크카드', '온라인 3% 캐시백', '온라인 3% 캐시백<br>
소셜커머스, 오픈마켓 5% 캐시백', 'https://www.lottecard.co.kr/app/LPCDADB_V100.lc?vtCdKndC=C12833-A12833');  
  INSERT INTO CREDITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-bc.jpg', '비씨카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=%EC%95%84%EC%9D%B4%ED%96%89%EB%B3%B5%EC%B9%B4%EB%93%9C-%EC%B2%B4%ED%81%AC[20170209153602775].jpg&fileType=carddamoa', '아이행복(체크)', '어린이집/유치원 육아학비 지원
보육맘 특화 서비스', '만 0세~만 5세 취학 전 아동 대상, 정부 보육료/유아학비 지원서비스 이용 가능<br>
보육맘 특화 서비스 : 정부지원금, 육아/교육/의료/쇼핑 등 추가 할인 혜택', 'https://www.bccard.com/app/card/ContentsLinkActn.do?pgm_id=ind0690');  
  INSERT INTO CREDITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-bc.jpg', '비씨카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=1._%ED%8E%98%EC%9D%B4%EB%B6%81%EB%A8%B8%EB%8B%88%EC%B2%B4%ED%81%AC%EC%B9%B4%EB%93%9C_%EC%95%9E%EB%A9%B4[20221006103136716].png&fileType=carddamoa', '페이북머니(체크)', '전월실적 없이 매월 페이북 머니 최대 1% 적립', '페이북 온오프라인 결제시 1% 페이북 머니 적립<br>
공부/간식/휴식 카테고리 0.5% 페이북 머니 적립<br>
일반가맹점 0.2% 페이북 머니 적립', 'https://www.bccard.com/app/card/CheckCardMain.do?gdsno=101681');  
  INSERT INTO CREDITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-bc.jpg', '비씨카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=2._%EB%B0%A5%EB%B0%94%EB%9D%BC%EB%B0%A5%ED%8E%98%EC%9D%B4%EB%B6%81%EB%A8%B8%EB%8B%88%EC%B2%B4%ED%81%AC%EC%B9%B4%EB%93%9C[20221006103251143].png&fileType=carddamoa', '밥바라밥 페이북머니(체크)', '외식 특화 기부카드', '종일커피/점심식사/저녁간식 페이북머니 8% 적립<br>
국내 가맹점 이용 금액 0.1% 기부 기금 적립', 'https://www.bccard.com/app/card/CheckCardMain.do?gdsno=102095');  
  INSERT INTO CREDITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-samsung.jpg', '삼성카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=%EA%B5%AD%EB%AF%BC%ED%96%89%EB%B3%B5_%EC%82%BC%EC%84%B1%EC%B2%B4%ED%81%AC%EC%B9%B4%EB%93%9C_V2_%ED%94%8C%EB%A0%88%EC%9D%B4%ED%8A%B8_%EC%82%AC%EC%9D%B4%EC%A6%88_%EC%A1%B0%EC%A0%95[20211109134831310].png&fileType=carddamoa', '국민행복 삼성체크카드v2', '임신부터 육아까지
아기와 엄마를 위한 행복한 혜택', '정부지원 국가바우처<br>
쿠팡,마켓컬리,어린이집 2% 캐시백<br>
신세계백화점 제휴서비스', 'https://www.samsungcard.com/personal/card/cardfinder/UHPPCA0102M0.jsp?code=ABP1689');  
  INSERT INTO CREDITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-samsung.jpg', '삼성카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=D17421L1_D17425L1_%EC%95%A4POINT_%EC%B2%B4%ED%81%AC_copy[20170120112217301].jpg&fileType=carddamoa', '삼성체크카드 & POINT', '쓸 땐 아껴 쓰고,
혜택은 아낌없이!', '0.2%~0.8% 빅포인트 적립<br>
CGV 3,000원 현장할인 또는 캐시백<br>
놀이공원 자유이용권 50%ㆍ워터파크 입장권 30% 현장할인', 'https://www.samsungcard.com/personal/card/cardfinder/UHPPCA0102M0.jsp?code=ABP1384');  
  INSERT INTO CREDITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-samsung.jpg', '삼성카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=D17420L1_D17424L1_%EC%95%A4CASHBACK_%EC%B2%B4%ED%81%AC_copy[20170120112307949].jpg&fileType=carddamoa', '삼성체크카드 & CASHBACK', '생활 소비만 해도
더블 캐시백', '0.2%~0.6% 캐시백<br>
CGV 3,000원 현장할인 또는 캐시백<br>
놀이공원 자유이용권 50%ㆍ워터파크 입장권 30% 현장할인', 'https://www.samsungcard.com/personal/card/cardfinder/UHPPCA0102M0.jsp?code=ABP1383');  
  INSERT INTO CREDITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/common/imageView?fileName=Deep_Dream[20171117151833114].jpg&fileType=carddamoa', '신한카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=Deep_Dream_%EC%B2%B4%ED%81%AC[20171117180406143].jpg&fileType=carddamoa', '신한카드 Deep Dream 체크', '한도없이 0.2% 적립, 많이 쓴 곳 5배 자동 적립 체크', '전월실적 제한 및 적립한도 없이 기본 0.2% 적립<br>
자주가는 DREAM 영역 기본의 3배(0.6%) 적립<br>
가장 많이 쓴 DREAM 영역 기본의 5배(1.0%) 자동 적립', 'https://www.shinhancard.com/conts/person/card_info/rookie/benefit/large/1463216_13353.jsp');  
  INSERT INTO CREDITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-shinhan.jpg', '신한카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=card_Triplus_%EC%A1%B0%EC%A0%95[20170119152405417].png&fileType=carddamoa', '신한카드 Triplus 체크', '여행에 혜택을 더한(Trip+plus) 마일리지 체크', '아시아나/대한항공 마일리지 적립<br>
Airbnb, Hotels.com, Expedia등 숙박예약 업체, 커피 추가 적립<br>
해외 현금인출 시 건당 $3, 인출액 1% 캐시백', 'https://www.shinhancard.com/conts/person/card_info/rookie/benefit/enjoy/1317826_13347.jsp');  
  INSERT INTO CREDITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-shinhan.jpg', '신한카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=img_Check_main_201510_%EC%A1%B0%EC%A0%95[20170119152600257].png&fileType=carddamoa', '신한카드 주거래 체크', '신한은행 결제계좌 연계 추가혜택 제공 체크카드', '전가맹점 0.3% 기본적립<br>
3대 백화점, 할인점, 온라인몰/소셜커머스, 해외이용 1% 적립<br>
이동통신요금 자동이체, 버스/지하철 후불교통, 도시가스 2% 특별적립', 'https://www.shinhancard.com/conts/person/card_info/rookie/benefit/wealth/1278822_13341.jsp');  
  INSERT INTO CREDITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-woori.jpg', '우리카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=NU%EC%98%A4%ED%95%98%EC%B3%8C2(%EC%98%A4%EB%8A%98%ED%95%98%EB%A3%A8%EC%B2%B4%ED%81%AC)_(158x250)[20230111112540137].png&fileType=carddamoa', 'NU오하쳌', '나의 생활패턴을 알아주는 든든한 카드', 'SHOPPING 5% 캐시백 / EAT 5% 캐시백 / PLAY 5% 캐시백 / LIFE 5% 캐시백', 'https://pc.wooricard.com/dcpc/yh1/crd/crd01/H1CRD101S02.do?cdPrdCd=102112');  
  INSERT INTO CREDITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-woori.jpg', '우리카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=NU_Uniq_Check(158x250)[20230111112549559].png&fileType=carddamoa', 'NU Uniq Check', '나를 위한 UNIQ한 선택', '국내 가맹점 0.2~0.3% 포인트 적립<br>
DAILY영역(쇼핑/교통/정기결제) 1% 적립 (가장 많이 이용한 영역 0.5% 한번 더 적립)<br>
EAT(커피/편의점/배달) 1% 적립', 'https://pc.wooricard.com/dcpc/yh1/crd/crd01/H1CRD101S02.do?cdPrdCd=101747');  
  INSERT INTO CREDITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-woori.jpg', '우리카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=%EC%B9%B4%EB%93%9C%EC%9D%98%EC%A0%95%EC%84%9D_SSO3_CHECK(250x158)[20230111112605205].png&fileType=carddamoa', '카드의 정석 SSO3 NEW-TRO CHECK', '집에서도 밖에서도 저녁을 더 즐겁게!', '저녁 5시~11시 모든 음식점, 주점, 배달의 민족 5% 캐시백<br>
대형마트, 편의점, 교통 5% 캐시백<br>
해외이용 2%~0.5% 캐시백', 'https://pc.wooricard.com/dcpc/yh1/crd/crd01/H1CRD101S02.do?cdPrdCd=100337');  
  INSERT INTO CREDITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-hana.jpg', '하나카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=%EB%AA%A8%EB%91%90%EC%9D%98%EC%9D%BC%EC%83%81_%EC%B2%B4%ED%81%AC%EC%B9%B4%EB%93%9C[20210604103531526].png&fileType=carddamoa', '모두의 일상(체크)', '전가맹점 어디서나 0.3%,페이결제 0.4% 적립', '-국내 전가맹점에서 0.3%, 페이결제 0.4% 적립<br>
-해외 전가맹점에서 0.4% 적립', 'https://www.hanacard.co.kr/OPI41000000D.web?schID=pcd&CD_PD_SEQ=12782');  
  INSERT INTO CREDITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-hana.jpg', '하나카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=%EB%AA%A8%EB%91%90%EC%9D%98%EA%B1%B4%EA%B0%95_%EC%B2%B4%ED%81%AC%EC%B9%B4%EB%93%9C[20210604103737464].png&fileType=carddamoa', '모두의 건강(체크)', '병원업종 0.4%,3대 마트 0.3%,전가맹점 0.2% 적립', '-병원적립 : 병원,동물병원,약국 업종 0.4% 적립<br>
-3대마트 : 이마트,홈플러스,롯데마트 0.3% 적립<br>
- 병원/마트외 국내외 전가맹점 0.2%', 'https://www.hanacard.co.kr/OPI41000000D.web?schID=pcd&CD_PD_SEQ=13539');  
  INSERT INTO CREDITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-hyundai.jpg', '현대카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=M%ED%95%98%EC%9D%B4%EB%B8%8C%EB%A6%AC%EB%93%9C[20190923161924432].JPG&fileType=carddamoa', '현대카드M HYBRID', '하이브리드 카드', '모든가맹점 0.5~1% M포인트 적립<br>
체크30%, 신용15% 연말정산 공제', 'https://www.hyundaicard.com/cpc/cr/CPCCR0201_01.hc?cardflag=&cardWcd=CMH&eventCode=DMH62');  
  INSERT INTO CREDITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-hyundai.jpg', '현대카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=M%EC%B2%B4%ED%81%AC[20190923161951402].JPG&fileType=carddamoa', '현대카드M CHECK', 'M포인트적립체크카드', '모든가맹점 0.5~1% M포인트 적립<br>
계좌잔액 내에서 결제가능(즉시출금)', 'https://www.hyundaicard.com/cpc/cr/CPCCR0201_01.hc?cardflag=&cardWcd=CMC&eventCode=DMH62');  
  INSERT INTO CREDITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-hyundai.jpg', '현대카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=X%EC%B2%B4%ED%81%AC[20190923162001678].JPG&fileType=carddamoa', '현대카드X CHECK', 'X캐시백적립체크카드', '모든가맹점 0.3~0.6% X캐시백 적립<br>
계좌잔액 내에서 결제가능(즉시출금)', 'https://www.hyundaicard.com/cpc/cr/CPCCR0201_01.hc?cardflag=&cardWcd=CXC&eventCode=DMH62');  
  INSERT INTO CREDITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-kb.jpg', '국민카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=%EB%A6%AC%EB%B8%8C%EB%A9%94%EC%9D%B4%ED%8A%B8%EC%B2%B4%ED%81%AC%EC%B9%B4%EB%93%9C_%EB%94%94%EC%9E%90%EC%9D%B8[20170117194745841].JPG&fileType=carddamoa', '리브메이트 체크카드', '전가맹점 포인트적립', '전가맹점 기본적립/커피제과, 영화관, 이동통신요금 자동납부 등 추가적립', 'https://card.kbcard.com/CXPRICAC0076.cms?mainCC=a&cooperationcode=01976&categoryCode=L0093&sGroupCode=2');  
  INSERT INTO CREDITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-kb.jpg', '국민카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=%EC%8B%A0%EB%94%94%EC%9E%90%EC%9D%B8_%EB%85%B8%EB%A6%AC%EC%B2%B4%ED%81%AC%EC%B9%B4%EB%93%9C[20170117194415366].JPG&fileType=carddamoa', '노리 체크카드', 'Youth 영역할인', '대중교통/이동통신요금 자동납부/CGV/스타벅스/에버랜드,롯데월드 등 할인', 'https://card.kbcard.com/CXPRICAC0076.cms?mainCC=a&cooperationcode=01664&categoryCode=L0093&sGroupCode=2');  
  INSERT INTO CREDITCARD(COMPANY_IMG, COMPANY_NM, PRODUCT_IMG, PRODUCT_NM, PRODUCT_CHAR, KEY_BENEFIT, DETAIL_URL)
VALUES ('https://gongsi.crefia.or.kr/assets/portal/images/content/card-logo-kb.jpg', '국민카드', 'https://gongsi.crefia.or.kr/common/imageView?fileName=%EC%B2%AD%EC%B6%98%EB%8C%80%EB%A1%9C%EC%8B%B1%EA%B8%80_%EC%A0%84%EB%A9%B4(%EB%A7%88%EC%8A%A4%ED%84%B0)[20170117194254039].JPG&fileType=carddamoa', '청춘대로싱글체크카드', '싱글 선호영역 할인', '편의점/다이소/소셜커머스/대중교통/택시/해외이용/올리브영/동물병원등 할인', 'https://card.kbcard.com/CXPRICAC0076.cms?mainCC=a&cooperationcode=01988&categoryCode=L0093&sGroupCode=2');  

SELECT * FROM CREDITCARD;

-- -------------------------------------
-- 부동산 정보 ----------------------------
-- -------------------------------------

-- APT 분양정보 상세조회 (청약 아파트 분양정보)
create table APTDetail(
	aptDno int primary key auto_increment, -- 일련번호
	bsns_mby_nm varchar(30), -- 사업주체명 (시행사) 
	cnstrct_entrps_nm varchar(30), -- 건설업체명 (시공사)  
	cntrct_cncls_bgnde DATETIME,	-- 계약시작일
	cntrct_cncls_endde DATETIME,	-- 계약종료일
	gnrl_rnk1_crsparea_rcept_pd DATETIME,	-- 1순위 접수일 해당지역
	gnrl_rnk1_etc_area_rcptde_pd DATETIME,	-- 1순위 접수일 경기지역
	gnrl_rnk1_etc_gg_rcptde_pd DATETIME,	-- 1순위 접수일 기타지역
	hmpg_adres varchar(200), -- 홈페이지주소
	house_dtl_secd_nm varchar(10), -- 주택상세구분코드명
	house_manage_no int, -- 주택관리번호
	house_nm varchar(50), -- 주택명
	house_secd_nm varchar(10),    -- 주택구분코드명
	hssply_adres varchar(100),   -- 공급위치
	hssply_zip varchar(5), -- 공급위치 우편번호
	mdhs_telno varchar(13), -- 문의처 
	mvn_prearnge_ym varchar(6), -- 입주예정월
	npln_prvopr_public_house_at char(1), -- 수도권 내 민영 공공주택지구 여부 Y/N
	parcprc_uls_at char(1), -- 분양가상한제 Y/N
	pblanc_no int, -- 공고번호
	pblanc_url varchar(100), -- 분양정보 URL
	przwner_presnatn_de DATETIME, -- 당첨자발표일

	public_house_earth_at char(1), -- 공공주택지구 Y/N
	rcept_bgnde DATETIME,	-- 청약접수시작일
	rcept_endde DATETIME,	-- 청약접수종료일
	rcrit_pblanc_de DATETIME,	-- 모집공고일
	rent_secd_nm varchar(10), -- 분양구분코드명
	speclt_rdn_earth_at char(1), -- 투기과열지구
	spsply_rcept_bgnde DATETIME, -- 특별공급 접수시작일 
	spsply_rcept_endde DATETIME, -- 특별공급 접수종료일
	subscrpt_area_code_nm varchar(10), -- 공급지역명
	tot_suply_hshldco int -- 공급규모
);

-- APT 분양정보/경쟁률 조회
-- drop table APTRate;
create table APTRate(
	aptRateNo int primary key auto_increment, -- 일련번호 
	house_manage_no int, -- 주택관리번호
	pblanc_no int, -- 공고번호
	house_ty varchar(10), -- 주택형
	reside_senm varchar(5), -- 거주지역
	subscrpt_rank_code int, -- 순위
	suply_hshldco int, -- 공급세대수
	req_cnt varchar(10), -- 접수건수
	cmpet_rate varchar(10), -- 경쟁률
	lwet_score int, -- 최저당첨가점
	top_score int, -- 최고당첨가점
	avrg_score int -- 평균당첨가점
);
select * from APTRate;

-- APT 분양정보 주택형별 상세조회
-- drop table APTHouseType;
create table APTHouseType (
	aptHouseNo int primary key auto_increment, -- 일련번호 
	etc_hshldco int, -- 특별공급-기타 세대수
	house_manage_no int, -- 주택관리번호
	house_ty varchar(10), -- 주택관리번호
	instt_recomend_hshldco int, --  특별공급-기관추천 세대수
	lfe_frst_hshldco int, -- 특별공급-생애최초 세대수
	lttot_top_amount varchar(20), -- 공급금액 (분양최고금액) (단위:만원)
	mnych_hshldco int, -- 특별공급-다자녀가구 세대수
	nwwds_hshldco int, -- 특별공급-신혼부부 세대수
	old_parnts_suport_hshldco int, -- 특별공급-노부모부양 세대수
	pblanc_no int, -- 공고번호
	spsply_hshldco int, -- 특별공급세대수
	suply_ar varchar(20), -- 공급면적
	suply_hshldco int, -- 일반공급세대수
	transr_instt_enfsn_hshldco int -- 특별공급-이전기관 세대수
);
select * from apthousetype;
select * from apthousetype as aht, aptrate as ar where aht.house_manage_no=ar.house_manage_no;

-- 오피스텔/도시형/민간임대 분양정보/경쟁률 조회
create table OfficeRate (
	officeRateNo int primary key auto_increment, 
	house_manage_no int, -- 주택관리번호	
	pblanc_no int, -- 공고번호

	house_ty varchar(5), -- 주택형
	suply_hshldco int, -- 공급세대수
	residnt_prior_at char(1), -- 거주자 우선여부
	resident_prior_senm varchar(5), -- 공급구분명
	req_cnt varchar(5), -- 접수건수
	cmpet_rate varchar(10) -- 경쟁률
);

-- 오피스텔/도시형/민간임대 분양정보 주택형별 상세조회
create table OfficeHouseType (
	officeHouseNo int primary key auto_increment, 
	excluse_ar decimal(5, 2), -- 전용면적
	gp char(1), -- 군
	house_manage_no int, -- 주택관리번호
	pblanc_no int, -- 공고번호
	subscrpt_reqst_amount varchar(5), -- 청약신청금
	suply_amount varchar(11), -- 공급금액 (분양최고금액)
	suply_hshldco int, -- 공급세대수
	tp varchar(10) -- 타입
);

-- 공공지원 민간임대 분양정보/경쟁률 조회
create table PublicRate (
	pubNo int primary key auto_increment, 

	house_manage_no int, -- 주택관리번호
	pblanc_no int, -- 공고번호
	house_ty varchar(5), -- 주택형
	suply_hshldco int, -- 공급세대수
	spsply_knd_nm varchar(5), -- 공급유형
	spsply_knd_hshldco int, -- 배정세대수
	req_cnt varchar(5), -- 접수건수
	cmpet_rate varchar(6) -- 경쟁률
);

-- APT 무순위/잔여세대 분양정보 주택형별 상세조회 상세기능 명세
create table RemainHouseType (
	remainHouseNo int primary key auto_increment, 
	house_manage_no int, -- 주택관리번호

	house_ty varchar(10), -- 모델타입
	lttot_top_amoun varchar(5), -- 공급금액 (분양최고금액)(단위:만원)
	pblanc_no int, --  공고번호
	suply_hshldco int -- 일반공급세대수
);

-- APT 무순위/잔여세대 분양정보 상세조회
create table RemainDetail (
	remainNo int primary key auto_increment, 

	bsns_mby_nm varchar(20), -- 사업주체명 (시행사)
	cntrct_cncls_bgnde DATETIME, -- 계약시작일
	cntrct_cncls_endde DATETIME, -- 계약종료일
	gnrl_rcept_bgnde DATETIME, -- 특별공급접수시작일
	gnrl_rcept_endde DATETIME,  -- 특별공급접수종료일
	hmpg_adres varchar(100), -- 홈페이지주소
	house_manage_no int, -- 주택관리번호
	house_dtl_secd_nm varchar(5), -- 주택상세구분코드명
	house_nm varchar(30), -- 주택명
	house_secd_nm varchar(10), -- 주택구분코드명
	hssply_adres varchar(100), -- 공급위치
	hssply_zip varchar(5), -- 공급위치 우편번호
	mdhs_telno varchar(13), -- 문의처
	mvn_prearnge_ym varchar(6), -- 입주예정월
	pblanc_no int, -- 공고번호
	pblanc_url varchar(100), -- 분양정보 URL

	przwner_presnatn_de DATETIME, -- 당첨자발표일
	rcrit_pblanc_de  DATETIME, -- 모집공고일
	spsply_rcept_bgnde DATETIME, -- 특별공급 접수시작일
	spsply_rcept_endde DATETIME, -- 특별공급 접수종료일
	subscrpt_rcept_bgnde DATETIME, -- 청약접수시작일
	subscrpt_rcept_endde DATETIME, -- 청약접수종료일

	tot_suply_hshldco int -- 공급규모
);

create table news (
	title varchar(50), 
	originallink varchar(255),
	link varchar(255),
	description varchar(500),
	pubDate DATETIME
);
-- --------------------------------
drop table investSimul; 
create table INVESTSIMUL (
	NO int,
    ordernum int auto_increment,
    orderdt DATETIME DEFAULT CURRENT_TIMESTAMP,
    stockcode varchar(10),
    stock varchar(30),
    tradestat VARCHAR(1) DEFAULT 'B' CHECK (tradestat IN('B', 'S')), -- B : 매수 / S : 매도
    price int,
    CNT int,
    paystat VARCHAR(1) DEFAULT 'Y' CHECK (paystat IN ('Y', 'N')), -- Y : 체결 / N : 미체결
    
    PRIMARY KEY (ordernum),
    FOREIGN KEY (NO) REFERENCES MEMBER(NO)
);
insert into investsimul values (1, 0, DEFAULT, '0013567', '삼성전자', 's', 1134000, 16, DEFAULT);
insert into investsimul values (1, 0, DEFAULT, '0465462', '현대자동차', 's', 6890000, 53, DEFAULT);
insert into investsimul values (1, 0, DEFAULT, '0308465', '테슬라', 'b', 5544000, 180, 'N');
insert into investsimul values (1, 0, DEFAULT, '0132765', '롯데', 'b', 23690000, 230, DEFAULT);
insert into investsimul values (2, 0, DEFAULT, '0013567', '삼성전자', 's', 1134000, 16, DEFAULT);
insert into investsimul values (2, 0, DEFAULT, '0465462', '현대자동차', 's', 6890000, 53, DEFAULT);
insert into investsimul values (2, 0, DEFAULT, '0308465', '테슬라', 'b', 5544000, 180, 'N');
insert into investsimul values (2, 0, DEFAULT, '0132765', '롯데', 'b', 23690000, 230, DEFAULT);

select NO, ordernum, orderdt, stockcode, stock, 
CASE tradestat when 'B' then '매수' else '매도' end, price, cnt, 
CASE paystat when 'Y' then '체결' else '미체결' end 
from investsimul;

select * from investsimul;

SELECT * FROM INVESTSIMUL, MEMBER WHERE INVESTSIMUL.NO=MEMBER.NO;

-- ---------
create table realEtate (
	realEtateNo
	Deal_Amount
	Build_Year
	Deal_Year
	Dong
	Apartment_Name
	Deal_Month
	Deal_Day
	AreaforExclusiveUse
	Jibun
	Regional_Code
	Floor
);