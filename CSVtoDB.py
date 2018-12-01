import sqlite3
import csv
import uuid

conn = sqlite3.connect("events.db")
cursor = conn.cursor()

cursor.execute("""CREATE TABLE IF NOT EXISTS events    (
    id  TEXT,
    title TEXT,
    date    INT,
    status  INT,
    PRIMARY KEY(id)
)""")


events = []
with open("eventData.csv") as csvfile:
    reader = csv.reader(csvfile)
    for row in reader:
        events.append([
            str(uuid.uuid4()),
            row[0],
            int(row[1]),
            row[2]
        ])

cursor.executemany("INSERT INTO events VALUES (?,?,?,?)", events)
conn.commit()

conn.close()