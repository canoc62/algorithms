//Input: a bunch of times, minutes and seconds, formatted as a single string like: "12:32 34:01 15:23 9:27 55:22 25:56"
// the sum of the times, hours, minutes, and seconds, formatted as a single string like: "2:32:41


function formatTime(times) {
  
  const timesArr = times.split(" ");
  
  const timeValues = timesArr.map((time) => {
    return time.split(":");
  });
  
  let seconds = 0;
  let minutes = 0;
  let hours = 0;
  let days = 0;
  
  timeValues.forEach((timeSubArr) => {
    const len = timeSubArr.length;
    
    if (len === 3) {
      seconds += parseInt(timeSubArr[2]);
      minutes += parseInt(timeSubArr[1]);
      hours += parseInt(timeSubArr[0]);
    } else if (len === 2) {
      seconds += parseInt(timeSubArr[1]);
      minutes += parseInt(timeSubArr[0]);
    } else {
      seconds += parseInt(timeSubArr[0]);
    }
  });
  
  const finalSeconds = seconds % 60;
  minutes += Math.floor(seconds / 60);
  
  const finalMinutes = minutes % 60;
  hours += Math.floor(minutes / 60);
  
  return `${hours}:${finalMinutes}:${finalSeconds}`;
}

formatTime("12:32:35 34:01:44 15:23:01 9:27:04 55:22:25 25:56");