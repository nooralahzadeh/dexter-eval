#!/usr/bin/env bash
source ./scripts/config.sh

EXPECTED_ARGS=4 

METRICS=metrics.txt
DEBUG=False
#DEBUG=True

if [ $# -ne $EXPECTED_ARGS ]
then
  echo "Usage: `basename $0` predictions[.json,.tsv] goldentruth[.json,.tsv] comparator metrics.txt"
  exit $E_BADARGS
fi

echo "evaluate prediction $1 against $2, using comparator $3"
$JAVA -Ddebug=$DEBUG -Dmetrics=$4 $CLI.EvaluatorCLI -input $1 -gt $2 -cmp $3
