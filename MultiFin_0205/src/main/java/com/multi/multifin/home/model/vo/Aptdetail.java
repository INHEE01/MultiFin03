package com.multi.multifin.home.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Aptdetail {

	int aptDno    ; 						//int primary key auto_increment, -- 일련번호                   
	String bsnsMbyNm  ; 					//varchar(30), -- 사업주체명 (시행사)                        
	String cnstrctEntrpsNm  ;				 // varchar(30), -- 건설업체명 (시공사)                 
	Date cntrctCnclsBgnde ; 					// DATETIME,	-- 계약시작일                             
	Date cntrct_cncls_endde ; 				// DATETIME,	-- 계약종료일                             
	Date gnrl_rnk1_crsparea_rcept_pd  ; 	// DATETIME,	-- 1순위 접수일 해당지역     
	Date gnrl_rnk1_etc_area_rcptde_pd ; 	// DATETIME,	-- 1순위 접수일 경기지역      
	String hmpg_adres  ; 					// varchar(200), -- 홈페이지주소                              
	String house_dtl_secd_nm ; 				// varchar(10), -- 주택상세구분코드명                   
	int house_manage_no   ; 				// int, -- 주택관리번호                                 
	String house_nm  ; 						//varchar(50), -- 주택명                                        
	String house_secd_nm  ; 				// varchar(10),    -- 주택구분코드명                       
	String hssply_adres ; 					// varchar(100),   -- 공급위치                               
	String hssply_zip ; 					// varchar(5), -- 공급위치 우편번호                            
	String mdhs_telno ; 					// varchar(13), -- 문의처                                      
	String mvn_prearnge_ym    ;				 // varchar(6), -- 입주예정월                           
	String npln_prvopr_public_house_at; 	// char(1), -- 수도권 내 민영 공공주택지구 여부Y/N
	char parcprc_uls_at; 					// char(1), -- 분양가상한제 Y/N                             
	int pblanc_no; 							// int, -- 공고번호                                              
	String pblanc_url ;						 // varchar(1000), -- 분양정보 URL                              
	Date przwner_presnatn_de   ;			 // DATETIME, -- 당첨자발표일                        
	char public_house_earth_at   ; 			//char(1), -- 공공주택지구 Y/N                    
	Date rcept_bgnde ; 						// DATETIME,	-- 청약접수시작일                             
	Date rcept_endde;						 // DATETIME,	-- 청약접수종료일                              
	Date rcrit_pblanc_de  ; 				// DATETIME,	-- 모집공고일                            
	String rent_secd_nm  ; 					// varchar(10), -- 분양구분코드명                           
	char speclt_rdn_earth_at  ; 			// char(1), -- 투기과열지구                          
	Date spsply_rcept_bgnde   ; 			// DATETIME, -- 특별공급 접수시작일                  
	Date spsply_rcept_endde    ; 			// DATETIME, -- 특별공급 접수종료일                 
	String subscrpt_area_code_nm    ; 		//varchar(10), -- 공급지역명                     
	int tot_suply_hshldco   ; 				// int -- 공급규모   
	
	
}
