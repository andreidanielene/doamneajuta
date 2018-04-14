from frontend import app
from flask import render_template, session, request
from flask_googlemaps import Map
import requests
import ast


@app.route('/get_offer_start')
def get_offer_start():
    param = request.args.get('param')
    d = ast.literal_eval(param)
    return render_template('/views/start_get_offer.html', item=d)


@app.route('/offers')
def offers():
    return 'Offer page'
