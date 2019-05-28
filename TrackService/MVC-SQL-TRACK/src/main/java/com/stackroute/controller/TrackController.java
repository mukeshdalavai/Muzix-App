package com.stackroute.controller;


import com.stackroute.crudRepositoryService.CrudRepository;
import com.stackroute.domain.Track;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*Annotate the class with @ControllerTest annotation. @ControllerTest annotation is used to mark
 * any POJO class as a controller so that Spring can recognize this class as a ControllerTest
 * */
@Controller
public class TrackController {
	public TrackController() {
	}
	/*
	 * From the problem statement, we can understand that the application
	 * requires us to implement the following functionalities.
	 *
	 * 1. display the list of existing notes from the collection. Each note
	 *    should contain Note Id, title, content, status and created date.
	 * 2. Add a new note which should contain the note id, title, content and status.
	 * 3. Delete an existing note.
	 * 4. Update an existing note.
	 */

	/*
	 * Get the application context from resources/beans.xml file using ClassPathXmlApplicationContext() class.
	 * Retrieve the Note object from the context.
	 * Retrieve the CurdReppositoryService object from the context.
	 */
	ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
	Track track =(Track) context.getBean("track");
	CrudRepository crudRepository =(CrudRepository) context.getBean("crudRepository");

	/*Define a handler method to read the existing notes by calling the getAllNotes() method
	 * of the CurdReppositoryService class and add it to the ModelMap which is an implementation of Map
	 * for use when building domain data for use with views. it should map to the default URL i.e. "/" */
	@RequestMapping("/")
	public String defaultHandler(ModelMap modelMap){

		modelMap.addAttribute("movies", crudRepository.displayData());
		return "index";
	}

	/*Define a handler method which will read the Note data from request parameters and
	 * save the note by calling the addNote() method of CurdReppositoryService class. Please note
	 * that the createdAt field should always be auto populated with system time and should not be accepted
	 * from the user. Also, after saving the note, it should show the same along with existing
	 * notes. Hence, reading notes has to be done here again and the retrieved notes object
	 * should be sent back to the view using ModelMap.
	 * This handler method should map to the URL "/saveNote".
	 */
	@PostMapping("addTrack")
	public String saveTrackHandler(@RequestParam("id") int id,@RequestParam("name") String trackName,@RequestParam("comments") String comments,ModelMap model){

		/* For Taking all parameters through a VECTOR (allRequestParams)
		note.setNoteId((int)allRequestParams.get(allRequestParams.indexOf("noteId")));
		note.setNoteTitle((String)allRequestParams.get(allRequestParams.indexOf("noteTitle")));
		note.setNoteContent((String)allRequestParams.get(allRequestParams.indexOf("noteContent")));
		note.setNoteStatus((String)allRequestParams.get(allRequestParams.indexOf("noteStatus")));
		*/
		track.setTrackId(id);
		track.setTrackName(trackName);
		track.setComments(comments);
		crudRepository.saveTrack(track);
		model.addAttribute("tracks", crudRepository.displayData());
		return "redirect:/";
	}

	/* Define a handler method to delete an existing note by calling the deleteNote() method
	 * of the CurdReppositoryService class
	 * This handler method should map to the URL "/deleteNote"
	 */
@PostMapping("/findTrack")
	public String findTrack(){
	return "findByName";
}

@PostMapping("/getAll")
	public String getAllTracks(ModelMap model) {
		model.addAttribute("tracks", crudRepository.displayData());
		return "getAllTracks";
	}

	Track track1 =(Track) context.getBean("track");
	@GetMapping("/findTrackByName")
	public String findTrackHandler(@RequestParam("name") String name,ModelMap model){
		model.addAttribute("tracks",crudRepository.displayTrackByName(name, track1));
		//model.addAttribute("tracks",crudRepository.displayData());
		return "findByName";
	}

	@PostMapping("/deleteTrack")
	public String deleteTrackHandler(@RequestParam("id") int deleteTrackID,ModelMap model){
		crudRepository.deleteTrack(deleteTrackID);
		model.addAttribute("tracks", crudRepository.displayData());
		return "redirect:/";
	}
}
