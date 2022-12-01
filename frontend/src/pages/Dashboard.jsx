import React from 'react'
import Layout from '../components/Layout'
import styled from 'styled-components';
import LeftNavbar from '../components/LeftNavbar';

const DashboardContainer = styled.div`
    display: flex;
    width: 100%;
    background-color: #060b26;
    color: white;
    justify-content: space-between;
    h2{
        margin-top: 17px;
    }
`

const Dashboard = () => {
    return (
        <Layout>
            <DashboardContainer>
                <LeftNavbar />
                <h2>
                    Ticketo
                </h2>
                <span> </span>
            </DashboardContainer>
        </Layout>
    )
}

export default Dashboard