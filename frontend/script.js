// URL base del API Gateway para consumir el backend expuesto
const apiUrl = "https://uber-api.execute-api.us-east-1.amazonaws.com/prod/api"; // URL de ejemplo del API Gateway

/**
 * Función para obtener todos los viajes disponibles.
 * Se hace una solicitud GET al endpoint /rides del API Gateway.
 */
async function fetchRides() {
    try {
        const response = await fetch(`${apiUrl}/rides`);
        if (!response.ok) {
            throw new Error('Error fetching rides');
        }
        const rides = await response.json();
        const ridesList = document.getElementById("rides");
        ridesList.innerHTML = rides.map(ride => 
            `<li>Ride from ${ride.origin} to ${ride.destination} - Status: ${ride.status}</li>`
        ).join('');
    } catch (error) {
        console.error('Error fetching rides:', error);
    }
}

/**
 * Función para solicitar un nuevo viaje.
 * Se hace una solicitud POST al endpoint /rides del API Gateway.
 */
async function requestRide() {
    const origin = document.getElementById("origin").value;
    const destination = document.getElementById("destination").value;
    const ride = { origin, destination, status: "requested" };

    try {
        const response = await fetch(`${apiUrl}/rides`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(ride),
        });

        if (!response.ok) {
            throw new Error('Error requesting ride');
        }

        // Actualizar la lista de viajes después de crear uno nuevo
        fetchRides();
    } catch (error) {
        console.error('Error requesting ride:', error);
    }
}

// Cargar todos los viajes al cargar la página
document.addEventListener("DOMContentLoaded", fetchRides);
