"""
This program is used to detect movement of the fish
@author: Nicolas Rigaudy
"""

import cv2
import numpy as np

cap = cv2.VideoCapture('fish_movement_test_2.mp4')                                                    #capture video from file

frame_width  = int( cap.get(cv2.CAP_PROP_FRAME_WIDTH))                                              #set frame height and width to height and width of video
frame_height = int( cap.get( cv2.CAP_PROP_FRAME_HEIGHT))

fourcc = cv2.VideoWriter_fourcc(*"X264")                                                            #initialize fourcc code for output result video
out = cv2.VideoWriter("output.mp4", fourcc, 15.0, (1280,720))                                       #initialize output file

ret, frame1 = cap.read()                                                                            #initialize two frames
ret, frame2 = cap.read()

while cap.isOpened() and cv2.waitKey(40) != 27:                                                     #while the video capture is running and the operator has not pressed esc
    diff             = cv2.absdiff(frame1, frame2)                                                  #look at the difference between the two frames
    gray             = cv2.cvtColor(diff, cv2.COLOR_BGR2GRAY)                                       #set it as grayscale for easier detection of contours
    blur             = cv2.GaussianBlur(gray, (5,5), 0)                                             #use Gaussian blur to make contours clearer
    _, thresh        = cv2.threshold(blur, 20, 255, cv2.THRESH_BINARY)                              #use binary threshold to separate contours
    dilated          = cv2.dilate(thresh, None, iterations=3)                                       #use dilate to fill in holes
    contours, _      = cv2.findContours(dilated, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)            #find and list contours

    for contour in contours:                                                                        #iterate through each contour
        (x, y, w, h) = cv2.boundingRect(contour)                                                    #find bounding rectangle of contour

        if cv2.contourArea(contour) < 900:                                                          #if area is too small, do not show contour box, helps eliminate false positives
            continue
        cv2.rectangle(frame1, (x, y), (x+w, y+h), (0, 255, 0), 2)                                   #print the bounding rectangle around contour
    #cv2.drawContours(frame1, contours, -1, (0, 255, 0), 2)                                         #enable to see contours

    image = cv2.resize(frame1, (1280,720))
    out.write(image)
    cv2.imshow("result", frame1)                                                                    #show result frame
    frame1 = frame2                                                                                 #assign frame 2 to frame 1
    ret, frame2 = cap.read()                                                                        #read new frame

cv2.destroyAllWindows()                                                                             #close all open windows
cap.release()                                                                                       #end the video capture
out.release()                                                                                       #close the output file writing