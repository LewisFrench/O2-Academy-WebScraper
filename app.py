from flask import Flask, render_template
import sqlite3
import time
app = Flask(__name__)

db = sqlite3.connect("events.db", check_same_thread=False)
db_cur = db.cursor()

class Event:
    def __init__(self, id, title, date, status):
        self.id = id
        self.title = title
        self.date = date
        self.status = status


    def get_month(self):
        return time.strftime("%B",time.localtime(self.date))

    def formatted_date(self):
        return time.strftime("%A %d \n %H:%M", (time.localtime(self.date)))
    def get_month_list(self):
        return ["December", "January", "February", "March", "May", "June", "July", "August", "September", "October", "November"]

    def get_status(self):
        return status


def load_events():
	e = []
	for row in db_cur.execute("SELECT * FROM events"):
		e.append(Event(row[0], row[1], row[2], row[3]))

	return e

@app.route("/")
def list():
	return render_template("list.html", events=load_events())

if __name__ == "__main__":
	app.debug = True # remove when publishing
	app.run(port = 8080)