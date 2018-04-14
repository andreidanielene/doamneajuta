from flask import Flask, render_template
from flask_googlemaps import GoogleMaps
from flask_googlemaps import Map
from frontend import app


@app.route("/test")
def mapview():


    return render_template('views/test.html')
