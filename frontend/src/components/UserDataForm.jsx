import React, { useState } from 'react';
import styled from 'styled-components';
import axiosInstance from '../api/axiosInstance'; 
import axios from 'axios';
import userEndPoints from '../api/userEndPoints';

const UserDataFormContainer = styled.form`
    display: flex;
    flex-direction: column;
    font-family: 'Open Sans', sans-serif;
    max-width: 500px;
    min-width: 400px;
    
    padding: 30px;
    border-radius: .25em;
    box-shadow : 0 .188em .550em rgba(156, 156, 156, 0.438);

    input:focus {
        background-color: white;
    }
    input, button {
        margin: 10px;
        padding: 18px;
        border: none;
        
        border-radius: 0.25em;
        text-align: center;
        font-size: 0.75em;
    }
    input {
        border: 1px solid #d8d8d8;
        text-align: left;
    }
    button{
        background-color: rgb(42, 109, 255);
        color: white;
        cursor: pointer;
    }
    h1 {
        font-weight: 400;
    }
    p {
        font-size: 0.75em;
        font-weight: 400;
        a {
            color: rgb(111, 157, 255);
            cursor: pointer;
        }
    }

    .lower {
        height: 50px;
        background-color: #fafafa;
    }
    label {
        color: red;
        font-size: .85rem;
        text-align: left;
        margin: 0 14px;
    }
    .redBorder {
        border: 1px solid #ff1616;
    }
`

const UserDataForm = ({ isForLogin }) => {
    const [userData, setUserData] = useState({})
    const [notMatchingPassword, setNotMatchingPassword] = useState(false)
    const [login, setLogin] = useState(isForLogin)

    const handleChange = (e) => {
        setUserData({
            ...userData,
            [e.target.name]: e.target.value
        });
    }

    const handleSetLogin = () => {
        // Reset the form
        if(notMatchingPassword) setNotMatchingPassword(false);
        setLogin(!login);
    }
    const handleLogin = async (e) => {
        e.preventDefault();
        const res = await axiosInstance.post(userEndPoints.login, userData);
        // const res = await axios.post('http://localhost:9191/users/login', userData);
        console.log(res);
    }

    const handleSignUp = (e) => {
        e.preventDefault();
        if (userData['password'] !== userData['conPassword']) setNotMatchingPassword(true);
        else setNotMatchingPassword(false);
    }


    return (
        <UserDataFormContainer onSubmit={login ? handleLogin : handleSignUp}>
            <h1>{login ? "Login" : "Sign Up"}</h1>
            {
                !login &&
                <>
                    <input onChange={handleChange} type="text" name="firstName" placeholder="First Name" />
                    <input onChange={handleChange} type="text" name="lastName" placeholder="Last Name" />
                </>
            }
            <input onChange={handleChange} type="email" name="email" placeholder="E-mail" />
            <input className={notMatchingPassword ? "redBorder" : ""} onChange={handleChange} type="password" placeholder="Password" name="password" />
            {notMatchingPassword && <label htmlFor='password'>Passwords are not matching</label> }
            {
                !login &&
                <>
                    <input className={notMatchingPassword ? "redBorder" : ""} onChange={handleChange} type="password" placeholder="Confirm Password" name="conPassword" />
                    {notMatchingPassword && <label htmlFor='conPassword'>Passwords are not matching</label> }
                </>
            }
            <button>{login ? "Login" : "Sign Up"}</button>
            { login ? 
                <p>Not a member? <a onClick={handleSetLogin}>Create Account</a></p>
                :
                <p>Already have an account? <a onClick={handleSetLogin}>Login</a></p>
            }
        </UserDataFormContainer>
    )
}

export default UserDataForm