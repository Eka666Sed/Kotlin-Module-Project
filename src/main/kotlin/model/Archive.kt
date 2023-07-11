package model

data class Archive(
  val id:String,
  val name:String
){
    private val notes: MutableList<Note> = mutableListOf()

    fun getNotes(): List<Note> = notes

    fun addNote(note: Note) {
        notes.add(note)
    }

    fun updateNote(note: Note) {
        val index = notes
                .indexOfFirst { it.id == note.id }
                .takeIf { it != -1 }
        index?.let {
            notes[it] = note
        }
    }
}