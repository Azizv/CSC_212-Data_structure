public class Photo {
	// Constructor
	LinkedList<String> tags;
	String path;
	public Photo(String path, LinkedList<String> tags) {
		this.path = path;
		this.tags = tags;
	}
	// Return the path (full file name) of the photo. A photo is uniquely identified by its path.
	public String getPath() {
		return path;
	}
	// Return all tags associated with the photo
	public LinkedList<String> getTags(){
		return tags;
	}
}
