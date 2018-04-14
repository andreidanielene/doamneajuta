from frontend import app
from flask import render_template, request, redirect, url_for
from flask_googlemaps import Map
import requests


@app.route('/login')
def login():
    return render_template('/views/login.html', login_css='', logout_css='hidden')


@app.route('/register')
def register():
    return render_template('/views/register.html', login_css='', logout_css='hidden')

#
# @app.route('/start_login')
# def start_login():
#     email = request.args.get('email')
#     password = request.args.get('password')
#     body = {
#         'username': email,
#         'password': password
#     }
#     #
#     # r = requests.post('http://192.168.21.114:8090/login', json=body)
#     #
#     # print '============'
#     # print r.json
#     # session['user_details'] = r.json
#     # print '=================username=='
#     # print session['user_details']
#
#     return redirect('/home')


@app.route("/home")
def home():
    r = requests.get('http://192.168.21.114:8090/api/fixtures')

    matches_details = r.json()

    markers = []
    for item in matches_details:
        markers.append({
            'icon': 'http://maps.google.com/mapfiles/ms/icons/green-dot.png',
            'lat': item['latitudine'],
            'lng': item['longitudine'],
            'infobox': '{} - {}'.format(item['homeTeamName'], item['awayTeamName'])
        })

    # creating a map in the view
    sndmap = Map(
        identifier="sndmap",
        lat=43.1865402,
        lng=14.2633723,
        markers=markers,
        style="height:400px;width:1024px;margin:0;",
        zoom=7,
        region="IT"
    )

    return render_template('views/home.html',
                           sndmap=sndmap,
                           login_css='hidden',
                           logout_css='',
                           matches=matches_details)


@app.route("/home_logout")
def home_logout():
    # creating a map in the view
    sndmap = Map(
        identifier="sndmap",
        lat=44.4378043,
        lng=26.0245982,
        markers=[
          {
             'icon': 'http://maps.google.com/mapfiles/ms/icons/green-dot.png',
             'lat': 44.447564,
             'lng': 26.0500967,
             'infobox': "<b>Hello World</b>"
          }
        ],
        style="height:400px;width:1024px;margin:0;"
    )

    return render_template('views/test.html', sndmap=sndmap, login_css='', logout_css='hidden')


@app.route("/start_login")
def start_login():
    email = request.args.get('email')
    password = request.args.get('password')
    body = {
        'username': email,
        'password': password
    }

    r = requests.post('http://192.168.21.114:8090/login', json=body)

    # session['user_details'] = r.json()
    # print '=================username=='
    # print session['user_details']

    return redirect('/home')


@app.route("/start_register")
def start_register():
    email = request.args.get('email')
    password = request.args.get('password')
    name = request.args.get('name')
    phone = request.args.get('phone')
    city = request.args.get('city')

    print '============='
    print email
    return 'works'