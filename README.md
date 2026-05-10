# Lab 2 - Software Quality Evaluation (ISO/IEC 25010 & 25023)

**Student:** Bekir Kaan ÇALIŞKAN
**Student ID:** 202328018
**Course:** SENG 272 - Software Project II

---

## About

A console Java application that evaluates the quality of different software
systems based on the **ISO/IEC 25010** quality model and the measurable
metrics defined in **ISO/IEC 25023**.

The program loads a small set of pre-defined software systems (Web and
Mobile categories), assigns measured values to their metrics, calculates
dimension and overall scores, and prints a structured evaluation report.

The lab covers:
- OOP principles (encapsulation, inheritance, toString override)
- ArrayList for managing dynamic lists of criteria and dimensions
- HashMap for grouping software systems by category
- Score calculation with formulas, clamping and rounding

---

## How to compile

\`\`\`bash
javac -d bin src/Criterion.java src/QualityDimension.java src/SWSystem.java src/SWSystemData.java src/Main.java
\`\`\`

## How to run

\`\`\`bash
java -cp bin Main
\`\`\`

The program prints a quality evaluation report for the **ShopSphere**
(Web - E-Commerce Platform) system.

---

## Project structure

\`\`\`
Lab2-sw-quality/
├── src/
│   ├── Criterion.java          (ISO 25023 metric, score formula)
│   ├── QualityDimension.java   (ISO 25010 characteristic + criteria list)
│   ├── SWSystem.java           (software system + dimensions + report)
│   ├── SWSystemData.java       (factory for systems via HashMap)
│   └── Main.java               (entry point and test data injection)
├── .gitignore
└── README.md
\`\`\`

---

## Score calculation

For a metric value the score is normalized between 1 and 5:

- Higher is better: \`score = 1 + (value - min) / (max - min) * 4\`
- Lower is better:  \`score = 5 - (value - min) / (max - min) * 4\`

The result is clamped to [1.0, 5.0] and rounded to the nearest 0.5.

The score of a quality dimension is the weighted average of its metrics:

\`dimensionScore = sum(metricScore * metricWeight) / sum(weights)\`

---

## Quality label classification

| Score range | Label |
|---|---|
| 4.5 - 5.0 | Excellent Quality |
| 3.5 - 4.4 | Good Quality |
| 2.5 - 3.4 | Needs Improvement |
| 1.0 - 2.4 | Poor Quality |

---

## ISO/IEC 25010 quality characteristics used

| Code | Name |
|---|---|
| QC.FS | Functional Suitability |
| QC.PE | Performance Efficiency |
| QC.RE | Reliability |
| QC.US | Usability |
| QC.SE | Security |
| QC.MA | Maintainability |

---

## ISO/IEC 25023 metric reference

| Characteristic | Metric | Direction | Unit |
|---|---|---|---|
| Functional Suitability | Functional Completeness Ratio | Higher | % |
| Functional Suitability | Functional Correctness Ratio | Higher | % |
| Reliability | Availability Ratio | Higher | % |
| Reliability | Defect Density | Lower | defect/KLOC |
| Reliability | MTBF | Higher | hours |
| Performance Efficiency | Response Time | Lower | ms |
| Performance Efficiency | Throughput | Higher | req/s |
| Performance Efficiency | CPU Utilisation Ratio | Lower | % |
| Usability | Task Completion Rate | Higher | % |
| Usability | User Error Rate | Lower | % |
| Security | Security Test Coverage | Higher | % |
| Security | Vulnerability Count | Lower | count |
| Maintainability | Test Coverage Ratio | Higher | % |
| Maintainability | Cyclomatic Complexity (avg) | Lower | score |

---

## Sample output

The Main class evaluates the ShopSphere system and prints a report
containing:

- System info (name, category, version)
- Each quality characteristic with its metrics, scores and dimension score
- Overall quality score
- Gap analysis (weakest characteristic and its quality gap)
