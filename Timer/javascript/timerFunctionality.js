var deadline = new Date(2018,9,9,10,26,0,0);
initializeClock('timerControl', deadline);



function initializeClock(id, deadline) {
  var timer = document.getElementById(id);
  var days = timer.querySelector('.days');
  var hours = timer.querySelector('.hours');
  var minutes = timer.querySelector('.minutes');
  var seconds = timer.querySelector('.seconds');

  function updateClock() {
    var time = getTimeRemaining(deadline);

    days.innerHTML = time.days;
    hours.innerHTML = ('0' + time.hours).slice(-2);
    minutes.innerHTML = ('0' + time.minutes).slice(-2);
    seconds.innerHTML = ('0' + time.seconds).slice(-2);

    if (time.total <= 0) {
      clearInterval(timeinterval);
    }
  }

  updateClock();
  var timeinterval = setInterval(updateClock, 1000);
}



function getTimeRemaining(deadline) {
  var time = Date.parse(deadline) - Date.parse(new Date());
  var seconds = Math.floor((time / 1000) % 60);
  var minutes = Math.floor((time / 1000 / 60) % 60);
  var hours = Math.floor((time / (1000 * 60 * 60)) % 24);
  var days = Math.floor(time / (1000 * 60 * 60 * 24));
  return {
    'total': time,
    'days': days,
    'hours': hours,
    'minutes': minutes,
    'seconds': seconds
  };
}