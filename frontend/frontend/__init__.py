from flask import Flask
from flask_googlemaps import GoogleMaps


app = Flask(__name__)

# you can set key as config
app.config['GOOGLEMAPS_KEY'] = "AIzaSyCPn8NwMmJzE67D2rKCpBqAkoim2EvU6bI"


# Initialize the extension
GoogleMaps(app)


@app.context_processor
def add_template_helpers():
    return dict(login_css='',
                logout_css='hidden',
                user='')


app.secret_key = 'super secret key'
app.config['SESSION_TYPE'] = 'filesystem'

import frontend.views.home
import frontend.views.test
import frontend.views.offers
