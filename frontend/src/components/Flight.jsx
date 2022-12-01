import React, { useEffect, useState } from 'react'
import styled from 'styled-components'
import createflightCode, { airportCodes } from '../utils/codes'
import { IoIosAirplane } from 'react-icons/io'
import calcTransitTime from '../utils/calculate'

const FlightContainer = styled.div`
    display: flex;
    padding: 4rem;
    border-radius: .25em;
    box-shadow : 0 .188em .550em rgba(156, 156, 156, 0.438);
    margin: 1rem;
    justify-content: space-between;
    /* text-align: center;
    align-items: center; */
    width: 500px;
    h4 {
        font-size: .9rem;
    }
    .time-of {

    }

    .line {
        width: 180px;
        /* height: 2px;
        background-color: #000; */
        background-color: #000;
        display: block;
        margin-top: .5rem;
        height: 2px;
    }

    .timeInfoCont{
        display: flex;
    }

    .sideValues{
        width: 100px;
    }

    .durationCont{
        margin: 0 2rem;
        display: flex;
        flex-direction: column;
        .duration__time {
            font-size: .8rem;
        }
    }

    .airplaneIcon{
        margin-top: 1px;
        margin-left: 6px;
    }

    .lineCont{
        display: flex;
    }
    .layovers {
        font-size: .7rem;
        .directFlights{
            color: green;
        }
        .nonDirectFlights {
            color: red;
        }
    }
`

const Flight = ({ airLineName, flightDate, layover, startPos, endPos, luggage, price, scale, transitDate }) => {
    const [flightCode, setFlightCode] = useState(null);
    const [dDate, dTime] = flightDate.split(' ');
    const [tDate, tTime] = transitDate.split(' ');

    useEffect(() => {
        setFlightCode(createflightCode());
    }, [])

    return (
        <FlightContainer>
            <div className='sideValues'>
                <h4>{airLineName}</h4>
            </div>
            <div className='timeInfoCont'>
                <div className='time-of'>
                    <h5>{dTime.substring(0, 5)}</h5>
                    <span>{startPos}</span>
                </div>
                <div className='durationCont'>
                    <p className='duration__time'>{calcTransitTime(transitDate, flightDate)}</p>
                    <div className='lineCont'>
                        <span className='line'></span><IoIosAirplane className='airplaneIcon'/>
                    </div>
                    <p className='layovers'>
                        {layover === 0 ? <span className='directFlight'>Direct</span> : <span className='nonDirectFlights'>{layover} stops</span>}
                    </p>
                </div>
                <div className='time-of'>
                    <h5>{tTime.substring(0, 5)}</h5>
                    <span>{endPos}</span>
                </div>
            </div>
            <div className='sideValues'>
                <p>{price} €</p>
            </div>
        </FlightContainer>
    )
}

export default Flight