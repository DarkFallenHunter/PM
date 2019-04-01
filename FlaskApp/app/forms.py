from wtforms import SelectField
from flask_wtf import FlaskForm


class SelectForm(FlaskForm):
    group = SelectField("Группа")
