package fr.univnantes.termsuite.ui.parts;

import java.io.File;
import java.io.IOException;

import com.google.common.base.Charsets;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.io.Files;

/**
 * 
 * A wrapper for an editable input object that can be 
 * adapted as a file.
 * 
 * @author Damien Cram
 *
 * @param <T>
 * 			The file-based input object type.
 * 
 */
public abstract class FileInput<T> {
	
	protected T inputObject;
	
	public FileInput(T inputObject) {
		super();
		Preconditions.checkNotNull(inputObject);
		this.inputObject = inputObject;
	}

	protected abstract File asFile();

	private File file = null;
	
	public File getFile() {
		if(file == null)
			file = asFile();
		return file;
	}
	
	
	public T getInputObject() {
		return inputObject;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FileInput<?>) {
			FileInput<?> fi = (FileInput<?>) obj;
			return Objects.equal(this.inputObject, fi.inputObject);
		} else
			return Objects.equal(this.inputObject, obj);
	}
	
	@Override
	public int hashCode() {
		return inputObject.hashCode();
	}

	public void save(String text) throws IOException {
		Files.write(text, getFile(), Charsets.UTF_8);
	}
}
