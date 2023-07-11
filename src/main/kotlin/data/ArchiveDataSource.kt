package data

import model.Archive
import model.Note
import java.util.UUID

object ArchiveDataSource {
    private val archives: MutableList<Archive> = mutableListOf()

    fun getArchives(): List<Archive> = archives

    fun createArchive(name: String) {
        val id = UUID.randomUUID().toString()
        val archive = Archive(id, name)
        archives.add(archive)
    }

    fun updateArchive(archive: Archive) {
        val index = archives
                .indexOfFirst { it.id == archive.id }
                .takeIf { it != -1 }
        index?.let {
            archives[it] = archive
        }
    }

    fun updateNoteInArchive(note: Note) {
        val archive = archives.first {
            note.id in it.getNotes()
                    .map { note -> note.id }
                    .toSet()
        }
        archive.updateNote(note)
        updateArchive(archive)
    }
}