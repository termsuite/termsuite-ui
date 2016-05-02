package fr.univnantes.termsuite.ui.dialogs;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;

import com.google.common.collect.Iterables;

import fr.univnantes.termsuite.ui.model.termsuiteui.ECorpus;
import fr.univnantes.termsuite.ui.viewers.CorpusContentProvider;
import fr.univnantes.termsuite.ui.viewers.CorpusLabelProvider;

public class CorpusSelectionDialog extends CheckedTreeSelectionDialog {

	public CorpusSelectionDialog(Shell parent, Iterable<ECorpus> inputCorpus) {
		super(parent, new CorpusLabelProvider(), new CorpusContentProvider());
		setContainerMode(true);
		setEmptyListMessage("No corpus to display. Please import a corpus.");
		setTitle("Select one or several corpus");
		setInput(inputCorpus);
		setExpandedElements(Iterables.toArray(inputCorpus, ECorpus.class));
	}
	
}
