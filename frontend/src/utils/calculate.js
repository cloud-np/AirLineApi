function calcTransitTime(date1, date2) {
    let arrivalDate = new Date(new Date(date1) - new Date(date2));
    return arrivalDate.getHours() + 'h ' + arrivalDate.getMinutes() + 'm';
}

export default calcTransitTime;