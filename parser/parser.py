import re
from fuzzywuzzy import fuzz, process

report_fields = [
    "nome",
    "obs",
    "publicacoes",
    "videos",
    "horas",
    "revisitas",
    "estudos",
]


def extract_from_lines(lines):
    def extract_from_field(field):
        line = process.extractOne(field, lines, scorer=fuzz.partial_ratio)[0]
        found = True if len(line) > 0 else False
        numbers = re.findall(r"\b\d+\b", line)

        if field in ["nome", "obs"]:
            return line.split(":", 1)[-1].strip() if found else ""
        else:
            return int(numbers[-1]) if len(numbers) > 0 else 0

    return extract_from_field


def parse_report(report):
    lines = report.splitlines()
    values = map(extract_from_lines(lines), report_fields)
    return dict(zip(report_fields, values))
