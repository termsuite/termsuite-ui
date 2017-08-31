package fr.univnantes.termsuite.ui.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.log.ILoggerProvider;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import fr.univnantes.termsuite.ui.services.NLPService;
import fr.univnantes.termsuite.ui.util.FileUtil;

public class ClearPreprocessingCacheHandler {
	public static final String ID = "fr.univnantes.termsuite.ui.handler.ClearPreprocessingCache";

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell parent, NLPService nlpService, ILoggerProvider loggerProvider) {
		long megaBytes = FileUtil.folderSize(nlpService.getNlpCachePath().toFile()) / (1024*1024);
		if(MessageDialog.openConfirm(parent, 
				"Clearing the cache", 
				String.format("The NLP preprocessing cache will be cleared. Space saved: %dMb. Are you sure ?", megaBytes))) {
			boolean clearNlpCache = nlpService.clearNlpCache();
			if(!clearNlpCache)
				MessageDialog.openError(parent, "Error", "Could not remove directory " + nlpService.getNlpCachePath());
		}
	}

}
