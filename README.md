# BabLog - 맛집 리뷰 게시판 서비스
> **미왕빌딩 근처에서 근무하거나 거주하는 사람들을 위한 맛집 리뷰 플랫폼**

## 📝 Summary

- ### 프로젝트명 : Bab-Log
- 프로젝트 주제 : 미왕빌딩 근처 맛집 조회 및 리뷰 등록 플랫폼
- 프로젝트 기간 : 2025. 05. 07 ~ 2025. 05 .09
- 배포링크 : <http://43.200.63.186/>


</br>

## 🚀 주요 기능 

  - JWT 기반 사용자 인증 (회원가입, 로그인/로그아웃)
 
    - 로그인
   
      토큰 기반으로 인증 관리 (Interceptor)
      
      로그인 성공 시 리뷰 작성시에 인증 토큰 기반 인증 진행


    - 로그아웃

      클라이언트에서 토큰 삭제 (혹은 서버에 Refresh 토큰 블랙리스트 등록
      
  - 리뷰(댓글) CRUD 기능

    - 맛집 리뷰 목록
      
      offset 페이징 기반 목록 조회

      좋아요 갯수, 댓글 갯수 조회

    - 리뷰 생성

      리뷰 생성 시 좋아요 추가 기능


    - 리뷰 코멘트 수정

      본인에 한해 리뷰 수정 가능

    - 리뷰 삭제

      본인에 한해 리뷰 수정 가능

  - 맛집 정보 조회 기능

    - 식당 목록 조회

      offset 페이징 기반 목록 조회

    - 식당 상세 조회

</br>

## 👥 팀 구성 (Team Member)
  
<table>
  <tr>
    <th>박병기</th>
    <th>이소은</th>
    <th>임재현</th>
    <th>안지현</th>
    <th>김선영</th>
  </tr>
  <tr>
    <td><img src="https://avatars.githubusercontent.com/u/48561660?v=4" width="150" height="150" alt="박병기"></td>
    <td><img src="https://avatars.githubusercontent.com/u/166477004?v=4" width="150" height="150" alt="이소은"></td>
    <td><img src="https://avatars.githubusercontent.com/u/133865673?v=4" width="150" height="150" alt="임재현"></td>
    <td><img src="https://avatars.githubusercontent.com/u/110217121?v=4" width="150" height="150" alt="안지현"></td>
    <td><img src="https://avatars.githubusercontent.com/u/101615063?v=4" width="150" height="150" alt="김선영"></td>
  </tr>
  <tr>
    <td><a href="https://github.com/pbg0205/">@pbg0205</a></td>
    <td><a href="https://github.com/soooo-ning">@soooo-ning</a></td>
    <td><a href="https://github.com/myaeba">@myaeba</a></td>
    <td><a href="https://github.com/jhroom">@jhroom</a></td>
    <td><a href="https://github.com/heroinesy">@heroinesy</a></td>
  </tr>
</table>

</br>

---

</br>

## ⛓️ 시스템 아키텍처
![image](https://cdn.discordapp.com/attachments/1369468548518514778/1370336052447019048/babLog_architecture_end.png?ex=681f2066&is=681dcee6&hm=a22c7ef44b97ec74d6dec223a8fad6639e5fd0d09256a3daeeccb15f23bed33e&)

</br>

## 📦 기술 스택 (Tech Stack)

### 🛠 Backend
  ![image](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
  ![image](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
  ![image](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)

---

### 💻 Frontend
![image](https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB)

---

### 🚀 Deployment
![image](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
<img src="https://img.shields.io/badge/Amazon%20EC2-FF9900?style=for-the-badge&logo=Amazon%20EC2&logoColor=white">
<img src="https://img.shields.io/badge/nginx-%23009639.svg?style=for-the-badge&logo=nginx&logoColor=white">

---
### 🛀 ETC
![image](https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=notion&logoColor=white)
![image](https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white)
![image](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
