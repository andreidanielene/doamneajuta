from flask import session


def set_active_link(page):
    if page == 'home':
        session['home'] = 'active'
        session['my_profile'] = ''
        session['external_products'] = ''
    else:
        session['home'] = ''
        session['my_profile'] = ''
        session['external_products'] = ''
