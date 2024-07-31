let date = new Date();
let activeDay;
let year = date.getFullYear();
let month = date.getMonth();

const calendarDate = document.querySelector(".calendar-dates"),
    currDate = document.querySelector(".calendar-current-date"),
    preNexIcons = document.querySelectorAll(".calendar-navigation span"),
    selectedDate = document.querySelector(".selected-date"),
    eventDay = document.querySelector(".event-day"),
    eventDate = document.querySelector(".event-date"),
    eventsContainer = document.querySelector(".events"),
    eventTitle = document.querySelector(".event-name "),
    eventDesc = document.querySelector(".event-desc"),
    eventFrom = document.querySelector(".event-time-from"),
    eventTo = document.querySelector(".event-time-to"),
    addEventOpenBtn = document.querySelector(".open-add-event"),
    addEventCloseBtn = document.querySelector(".close-add-event"),
    eventsArr = eventsList;
const months = [
    "January",
    "February",
    "March",
    "April",
    "May",
    "June",
    "July",
    "August",
    "September",
    "October",
    "November",
    "December"
];

console.log(eventsArr);

const formatDate = (date) => {
    return date.toLocaleDateString('en-US', {
        month: 'short',
        day: 'numeric',
        year: 'numeric'
    });
}; 

const getEvent = (date, day) => {
       const selectedEvents = eventsArr.filter(event => event.event_date === date);

    if (selectedEvents.length > 0) {
        let eventsHTML = '';
        selectedEvents.forEach(event => {
            eventsHTML += `
                <div class="events">
                    <div class="event-name">${event.event_name}</div>
                    <div class="event-time">
                        <div class="event-time-from">Time: ${event.time_from}</div>
                        <div class="event-time-to"> - ${event.time_to}</div>
                    </div>
                    <div class="event-desc">${event.event_desc}</div>
                </div>
            `;
        });

        document.querySelector('.event-container').style.display = 'block';
        document.querySelector('.event-container').innerHTML = eventsHTML;

    } else {
        document.querySelector('.event-container').style.display = 'block';
        document.querySelector('.event-container').innerHTML = '<p>No events for today</p>';
    }
    eventDay.innerText = day;
    eventDate.innerText = date;
}

const displayCalendar = () => {
    console.log("Displaying calendar...");
    let dayone = new Date(year, month, 1).getDay();
    let lastdate = new Date(year, month + 1, 0).getDate();
    let dayend = new Date(year, month, lastdate).getDay();
    let monthlastdate = new Date(year, month, 0).getDate();

    let day = "";
    
    // loop to add the last dates of the previous month
    for (let i = dayone; i > 0; i--) {
        day += `<li class="inactive">${monthlastdate - i + 1}</li>`;
    }

    // loop to add the dates of the current month
    for (let i = 1; i <= lastdate; i++) {
        const eventForDate = eventsList.find((event) => {
            const eventDate = new Date(event.event_date);
            return (
                eventDate.getDate() === i &&
                eventDate.getMonth() === month &&
                eventDate.getFullYear() === year
            );
        });

        let isToday =
            i === date.getDate() &&
            month === new Date().getMonth() &&
            year === new Date().getFullYear()
                ? "active"
                : "";

        let hasEvent = eventForDate ? "has-event" : "";

        day += `<li class="${isToday} ${hasEvent}" data-day="${i}">${i}</li>`;

        if(isToday){
            let dateofDay =  new Date();
            console.log("Today's date: " +dateofDay);
            let today = formatDate(dateofDay);
            const strToday = new Date().toLocaleString('en-us', {  weekday: 'long' });

            getEvent(today, strToday);
        }  
    }

    // loop to add the first dates of the next month
    for (let i = dayend; i < 6; i++) {
        day += `<li class="inactive">${i - dayend + 1}</li>`;
    }

    // update the text of the current date element with the formatted current month and year
    if (currDate) {
        currDate.innerText = `${months[month]} ${year}`;
    } else {
        console.error("Error: Element with class 'calendar-current-date' not found.");
    }

    // update the HTML of the dates element with the generated calendar
    if (calendarDate) {
        calendarDate.innerHTML = day;

    }
};

displayCalendar();

preNexIcons.forEach((icon) => {
    icon.addEventListener("click", () => {

        month = icon.id === "calendar-prev" ? month - 1 : month + 1;
        if (month < 0 || month > 11) {
            date = new Date(year, month, new Date().getDate());
            year = date.getFullYear();
            month = date.getMonth();
        } else {
            date = new Date();
        }

        displayCalendar();
    });
});

document.querySelectorAll(".calendar-dates li").forEach((dateElement) => {
    dateElement.addEventListener('click', (event) => {
        const selectedDay = parseInt(event.target.dataset.day);
        const selectedDate = new Date(year, month, selectedDay);
        let strDay = new Date().toLocaleString('en-us', {  weekday: 'long' });
        let formattedDate = formatDate(selectedDate);
        console.log("Selected Date: " +formattedDate);
        getEvent(formattedDate, strDay);
    });
}); 

function openAddEventForm() {
    document.getElementById("addEventForm").style.display = "block";
}
  
function closeAddEventForm() {
    document.getElementById("addEventForm").style.display = "none";
}
  
    
