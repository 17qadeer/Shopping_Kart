<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<style type="text/css">
@import url("https://fonts.googleapis.com/css?family=Fira+Sans");

html,body {
    position: relative;
    min-height: 100vh;
    background-color: #E1E8EE;
    display: flex;
    align-items: center;
    justify-content: center;
    font-family: "Fira Sans", Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
}

.form-structor {
    background-color: #222;
    border-radius: 15px;
    height: 550px;
    width: 350px;
    position: relative;
    overflow: hidden;
    
    &::after {
        content: '';
        opacity: .8;
        position: absolute;
        top: 0;right:0;bottom:0;left:0;
        background-repeat: no-repeat;
        background-position: left bottom;
        background-size: 450px 700px;
        background-image: url('https://images.unsplash.com/photo-1542674684-fba3fa06625b?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NjB8fHNuZWFrZXJ8ZW58MHx8MHx8fDA%3D');
    }
    
    .profile {
        position: absolute;
        top: 50%;
        left: 50%;
        -webkit-transform: translate(-50%, -50%);
        width: 65%;
        z-index: 5;
        -webkit-transition: all .3s ease;
    }
    
    .profile .profile-details {
        border-radius: 15px;
        background-color: #fff;
        overflow: hidden;
        margin-top: 50px;
        opacity: 1;
        visibility: visible;
        padding: 20px;
    }
    
    .profile .profile-details h2 {
        font-size: 1.7em;
        color: #000;
        margin-bottom: 15px;
        text-align: center;
    }
    
    .profile .profile-details p {
        font-size: 14px;
        color: #666;
        margin-bottom: 10px;
    }

    .edit-profile-btn {
        background-color: #7C9092;
        color: rgba(256,256,256,0.7);
        border:0;
        border-radius: 15px;
        display: block;
        margin: 15px auto; 
        padding: 15px 45px;
        width: 100%;
        font-size: 13px;
        font-weight: bold;
        cursor: pointer;
        opacity: 1;
        visibility: visible;
        -webkit-transition: all .3s ease;
    }

    .edit-profile-btn:hover {
        transition: all .3s ease;
        background-color: rgba(0,0,0,0.8);
    }
}
</style>
</head>
<body>
<div class="form-structor">
    <div class="profile">
        <div class="profile-details">
        <c:forEach var="user" items="${list}">
            <h2>User Profile</h2>
            <p><strong>Username:</strong>${user.username}</p>
            <p><strong>Email:</strong>${user.email}</p>
            <p><strong>Password:</strong> ${user.password}</p>
            <p><strong>Phone Number:</strong> ${user.phoneNo}</p>
            <p><strong>Address:</strong><br>${user.address}</p>
        </c:forEach>
            <a href="${pageContext.request.contextPath}/editprofile"><button class="edit-profile-btn" type="submit">Edit Profile</button></a>
            <a href="${pageContext.request.contextPath}/"><button class="edit-profile-btn" type="submit">Home</button></a>
            <a href="${pageContext.request.contextPath}/logout"><button class="edit-profile-btn" type="submit">Logout</button></a>
        </div>
    </div>
</div>
</body>
</html>
