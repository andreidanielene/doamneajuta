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


# def show_hide_login():
#     if session['status'] == 'login':
#         session['logoutCss'] = 'display:none'
#         session['loginCss'] = ''
#     else:
#         session['logoutCss'] = ''
#         session['loginCss'] = 'display:none'
