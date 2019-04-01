from flask import render_template
from app import app
from app.forms import SelectForm
import requests


base = 'http://up-lab2.mirea.ru/student/all'


def get_group_list():
    data = requests.get(base).json()
    ans = []
    for i in data:
        ans.append(i['studyGroupId'])
    d = [(str(i), 'ИВБО-02-15-'+str(i)) for i in list(set(ans))]
    d = [('0', 'Все')] + d
    return d


def get_group(id=None):
    data = requests.get(base).json()
    if not id or id == '0':
        return data
    else:
        try:
            return [i for i in data if i["studyGroupId"] == int(id)]
        except Exception as e:
            return data


@app.route('/', methods=['GET', 'POST'])
def students():
    form = SelectForm()
    form.group.choices = get_group_list()
    data = None
    if (form.group.data!="None"):
        data = get_group(form.group.data)
    else:
        data = get_group()

    return render_template("table.html", students=data, form=form)


# @app.route('/index', methods=['GET', 'POST'])
# @app.route('/', methods=['GET', 'POST'])
# def hello_world():
#     resp = requests.get('http://localhost:8080/groups')
#     groups = resp.json()
#
#     choices = [(3, 'ИВБО-02-15-3'), (4, 'ИВБО-02-15-4')]
#     for group in groups:
#         choices.append((group['id'], group['name']))
#     form = SelectForm()
#     form.group.choices = choices
#
#     group_id = form.group.data
#
#     resp = requests.get('http://localhost:8080/students&group={}'.format(group_id))
#     students = resp.json()
#
#     students_jubjects_marks = []
#
#     for student in students:
#         resp = requests.get('http://localhost:8080/journal_records&student_id={}'.format(student['id']))
#         students_marks = resp.json()
#         print(students_marks)
#
#     students = [
#         {'name': 'Иванов Иван Иванович', 'markPrIS': 5, 'markSII': 4},
#         {'name': 'Петров Пётр Петрович', 'markPrIS': 3, 'markSII': 2}
#     ]
#
#     return render_template('table.html', students=students, form=form)
