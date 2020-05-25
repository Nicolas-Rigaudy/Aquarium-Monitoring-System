"""
This program is used to detect movement of the fish
@author: Nicolas Rigaudy
"""

import cv2
import numpy as np

cap = cv2.VideoCapture('fish_movement_test_2.mp4')                                                    #capture video from file

#frame_width  = int( cap.get(cv2.CAP_PROP_FRAME_WIDTH))                                               #set frame height and width to height and width of video
#frame_height = int( cap.get( cv2.CAP_PROP_FRAME_HEIGHT))

#fourcc = cv2.VideoWriter_fourcc('X','V','I','D')

#out = cv2.VideoWriter("output.avi", fourcc, 5.0, (1280,720))

ret, frame1 = cap.read()                                                                            #initialize two frames
ret, frame2 = cap.read()
#print(frame1.shape)

while cap.isOpened():
    diff             = cv2.absdiff(frame1, frame2)                                                  #look at the difference between the two frames
    gray             = cv2.cvtColor(diff, cv2.COLOR_BGR2GRAY)                                       #set it as grayscale for easier detection of contours
    blur             = cv2.GaussianBlur(gray, (5,5), 0)                                             #use Gaussian blur to make contours clearer
    _, thresh        = cv2.threshold(blur, 20, 255, cv2.THRESH_BINARY)                              #use binary threshold to separate contours
    dilated          = cv2.dilate(thresh, None, iterations=3)                                       #use dilate to fill in holes
    contours, _      = cv2.findContours(dilated, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)            #find and list contours

    #for contour in contours:
        #(x, y, w, h) = cv2.boundingRect(contour)

        #if cv2.contourArea(contour) < 900:
            #continue
        #cv2.rectangle(frame1, (x, y), (x+w, y+h), (0, 255, 0), 2)
        #cv2.putText(frame1, "Status: {}".format('Movement'), (10, 20), cv2.FONT_HERSHEY_SIMPLEX,
                    #1, (0, 0, 255), 3)
    cv2.drawContours(frame1, contours, -1, (0, 255, 0), 2)                                          #enable to see contours

    #image = cv2.resize(frame1, (1280,720))
    #out.write(image)
    cv2.imshow("result", frame1)                                                                    #show result frame
    frame1 = frame2                                                                                 #assign frame 2 to frame 1
    ret, frame2 = cap.read()                                                                        #read new frame

    if cv2.waitKey(40) == 27:
        break

cv2.destroyAllWindows()
cap.release()
#out.release()