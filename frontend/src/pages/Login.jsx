import React from 'react'
import Layout from '../components/Layout';
import UserDataForm from '../components/UserDataForm';
import styled from 'styled-components';

const LoginContainer = styled.div`
    padding: 5rem;
`

const Login = () => {

  return (
    <Layout>
        <LoginContainer>
            <UserDataForm />
        </LoginContainer>
    </Layout>
  )
}

export default Login