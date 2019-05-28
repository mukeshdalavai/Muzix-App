package com.stackroute.domain;

/*
 * The class "Note" will be acting as the data domain for the Note data in the ArrayList.
 */
public class Track {

	/*
	 * This class should have five fields (noteId, noteTitle, noteContent,
	 * noteStatus and createdAt). This class should also contain the getters and
	 * setters for the fields. The value of createdAt should not be accepted from
	 * the user but should be always initialized with the system date
	 */
	private int trackId;
	private String trackName;
	private String comments;
	public Track() {
	}

	/* All the getters/setters definition should be implemented here */

	public int getTrackId() {
		return trackId;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Track{" +
				"trackId=" + trackId +
				", trackName='" + trackName + '\'' +
				", comments='" + comments + '\'' +
				'}';
	}
}
