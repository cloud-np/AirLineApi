import React from 'react'
import styled from 'styled-components'
import Flight from './Flight'

const ShowFlightsContainer = styled.div`
    display: flex;
    flex-direction: column;
`

const ShowFlights = ({ flights }) => {
    return (
        <ShowFlightsContainer>
            {flights?.map((flight, index) =>
                <Flight key={index} {...flight} />
            )}
        </ShowFlightsContainer>
    )
}

export default ShowFlights