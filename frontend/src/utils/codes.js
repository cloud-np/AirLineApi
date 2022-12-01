function createflightCode() {
  let result = '';
  for (let i = 0; i < 6; i++) {
    if(i > 1) result += '0123456789'.charAt(Math.floor(Math.random() * 10))
    else      result += 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'.charAt(Math.floor(Math.random() * 24));
  }
  return result;
}
export default createflightCode; 

// Map airport codes to airport names
export const airportCodes = {
  "LHR": "London Heathrow",
  "LGW": "London Gatwick",
  "LBA": "Leeds Bradford",
  "LTN": "London Luton",
  "STN": "London Stansted",
  "SEN": "Southend",
  "LCY": "London City",
  "BHX": "Birmingham",
  "BER": "Berlin",
  "MAD": "Madrid",
  "AUH": "Abu Dhabi",
  "ARN": "Stockholm",
  "CAI": "Cairo",
  "ATH": "Athens",
}

// Map flight code to flight name
// const flightCodes = {
//   'AA': 'American Airlines',
//   'BA': 'British Airways',
//   'CA': 'Air China',
//   'CX': 'Cathay Pacific',
//   'EK': 'Emirates',
//   'IB': 'Iberia',
//   'LH': 'Lufthansa',
//   'QR': 'Qatar Airways',
//   'SA': 'South African Airways',
//   'SQ': 'Singapore Airlines',
//   'UA': 'United Airlines',
//   'VS': 'Virgin Atlantic',
//   'AC': 'Air Canada',
//   'AF': 'Air France',
//   'BR': 'EVA Air',
//   'CI': 'China Airlines',
//   'DL': 'Delta Airlines',
//   'EY': 'Etihad Airways',
//   'H2': 'Hainan Airlines',
//   'JL': 'Japan Airlines',
//   'KE': 'Korean Air',
//   'KQ': 'Kenya Airways',
//   'MH': 'Malaysia Airlines',
//   'NZ': 'Air New Zealand',
//   'OS': 'Austrian Airlines',
//   'TK': 'Turkish Airlines',
//   'UA': 'United Airlines',
//   'VA': 'Virgin Australia',
//   'WS': 'Westjet',
//   'ZH': 'Shenzhen Airlines',
//   'W6': 'Wizz Air',
//   'F9': 'Frontier Airlines',
//   'B6': 'JetBlue Airways',
//   'G4': 'Allegiant Air',
//   'NK': 'Spirit Airlines',
//   'WN': 'Southwest Airlines',
//   'FV': 'Rossiya Airlines',
//   'KL': 'KLM',
//   'AZ': 'Alitalia',
//   'LX': 'Swiss International Air Lines',
//   'AF': 'Air France',
//   'SN': 'Brussels Airlines',
//   'TP': 'TAP Portugal',
//   'U2': 'easyJet',