import React, { useEffect, useState } from 'react'
import Layout from '../components/Layout'
import LeftNavbar from '../components/LeftNavbar'
import serverInstance from '../api/axiosInstance'
import reservationsEndpoints from '../api/reservationsEndpoints'
import Flight from '../components/Flight'
import ShowFlights from '../components/ShowFlights'

const Reservations = () => {
    const [user, setUser] = useState(null);
    const [flights, setFlights] = useState(null);
    const [reservations, setReservations] = useState(null);

    useEffect(() => {
        const sessionUser = JSON.parse(localStorage.getItem('user'));
        setUser(sessionUser);

        const fetchReservations = async (userId) => {
            const res = await serverInstance.get(reservationsEndpoints.getAllReservations + userId);
            setFlights(res.data.flights);
            setReservations(res.data.reservations);
        }
        fetchReservations(sessionUser.userId);
    }, []);

    return (
        <Layout>
            <LeftNavbar />
            <ShowFlights flights={flights}/>
        </Layout>
    )
}

export default Reservations