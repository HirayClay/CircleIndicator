# CircleIndicator<br>
an viewpager indicator with cute dots that reponse to viewpager's scroll<br>
![image](https://github.com/HirayClay/CircleIndicator/raw/master/app/static/shot.gif "poor picture quality")<br>
How?
===
there is no magic,i just know ViewPager could add PageChangeListener,with the callback we could get the ViewPager's current item showing and the page scroll offset([0,1)),so we can move the circle corresponding to the ViewPager's scroll<br>

Usage
===
there is some attributes below:<br>
bubble_mode: background,overlay<br>
bubble_gravity:left,center,right<br>
numer:the circle's quantity<br>
radius : circle radius<br>
gap:the space between circles
