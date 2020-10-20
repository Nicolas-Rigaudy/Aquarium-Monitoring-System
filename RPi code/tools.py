from datetime import datetime

def dateTime():
    now = datetime.now()
    timeString = now.strftime("%d/%m/%Y/%H:%M:%S")
    return timeString
