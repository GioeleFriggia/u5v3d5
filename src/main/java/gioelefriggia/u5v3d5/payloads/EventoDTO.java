package gioelefriggia.u5v3d5.payloads;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class EventoDTO {
    @NotBlank(message = "Il titolo dell'evento è obbligatorio.")
    @Size(min = 5, max = 100, message = "Il titolo deve avere tra 5 e 100 caratteri.")
    private String title;

    @NotBlank(message = "La descrizione è obbligatoria.")
    @Size(min = 10, max = 500, message = "La descrizione deve avere tra 10 e 500 caratteri.")
    private String description;

    @Future(message = "La data e l'ora devono essere future.")
    private LocalDateTime date;

    @NotBlank(message = "Il luogo è obbligatorio.")
    private String location;

    @Min(value = 1, message = "Ci deve essere almeno un posto disponibile.")
    private int availableSeats;

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
