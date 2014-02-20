/**
 *  Copyright 2014 Diego Ceccarelli
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

/**
 *  Copyright 2014 Diego Ceccarelli
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package it.cnr.isti.hpc.dexter.eval.cli;

import it.cnr.isti.hpc.cli.AbstractCommandLineInterface;
import it.cnr.isti.hpc.dexter.eval.Evaluator;
import it.cnr.isti.hpc.dexter.eval.cmp.EntityComparator;
import it.cnr.isti.hpc.dexter.eval.reader.AnnotatedSpotReader;
import it.cnr.isti.hpc.dexter.eval.reader.JsonAnnotatedSpotReader;
import it.cnr.isti.hpc.dexter.eval.reader.TsvAnnotatedSpotReader;

/**
 * @author Diego Ceccarelli <diego.ceccarelli@isti.cnr.it>
 * 
 *         Created on Feb 17, 2014
 */
public class EvaluatorCLI extends AbstractCommandLineInterface {

	private static String usage = "java -jar $jar  it.cnr.isti.hpc.dexter.eval.cli.EvaluatorCLI -input predictions.tsv[.gz] -gt goldentruth.tsv[.gz]";
	private static String[] params = new String[] { INPUT, "gt" };

	public EvaluatorCLI(String[] args) {
		super(args, params, usage);
	}

	public static void main(String[] args) {
		EvaluatorCLI cli = new EvaluatorCLI(args);
		String input = cli.getInput();
		String gt = cli.getParam("gt");
		AnnotatedSpotReader predictionsReader = null;
		AnnotatedSpotReader goldenTruthReader = null;

		if (input.endsWith(".tsv") || input.endsWith(".tsv.gz")) {
			predictionsReader = new TsvAnnotatedSpotReader(input);
		}
		if (input.endsWith(".json") || input.endsWith(".json.gz")) {
			predictionsReader = new JsonAnnotatedSpotReader(input);
		}

		if (gt.endsWith(".tsv") || gt.endsWith(".tsv.gz")) {
			goldenTruthReader = new TsvAnnotatedSpotReader(gt);
		}
		if (gt.endsWith(".json") || gt.endsWith(".json.gz")) {
			goldenTruthReader = new JsonAnnotatedSpotReader(gt);
		}

		Evaluator evaluator = new Evaluator(predictionsReader,
				goldenTruthReader, new EntityComparator());
		evaluator.run();
	}
}
