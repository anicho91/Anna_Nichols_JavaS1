package com.company.reccolldao.service;

import com.company.reccolldao.dao.*;
import com.company.reccolldao.model.Album;
import com.company.reccolldao.model.Artist;
import com.company.reccolldao.model.Label;
import com.company.reccolldao.model.Track;
import com.company.reccolldao.viewmodel.AlbumViewModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ServiceLayerTest {

    private AlbumDao albumDao;
    private ArtistDao artistDao;
    private LabelDao labelDao;
    private TrackDao trackDao;
    private ServiceLayer service;


    private  void setupAlbumDaoMock(){
        albumDao = mock(AlbumDaoJdbcTemplateImpl.class);
        Album album = new Album();
        album.setId(1);
        album.setArtistId(45);
        album.setLabelId(10);
        album.setTitle("Greatest Hits");
        album.setListPrice(new BigDecimal("14.99"));
        album.setReleaseDate(LocalDate.of(1999, 05, 15));

        Album album2 = new Album();
        album2.setArtistId(45);
        album2.setLabelId(10);
        album2.setTitle("Greatest Hits");
        album2.setListPrice(new BigDecimal("14.99"));
        album2.setReleaseDate(LocalDate.of(1999, 05, 15));

        List<Album> aList = new ArrayList<>();
        aList.add(album);

        doReturn(album).when(albumDao).addAlbum(album2);
        doReturn(album).when(albumDao).getAlbum(1);
        doReturn(aList).when(albumDao).getAllAlbums();
    }


    private void setupLabelDaoMock(){
        labelDao = mock(LabelDaoJdbcTemplateImpl.class);
        Label label = new Label();
        label.setId(10);
        label.setName("BlahStudios");
        label.setWebsite("www.site.com");

        Label label2 = new Label();
        label2.setName("BlahStudios");
        label2.setWebsite("www.site.com");

        List<Label> labelList = new ArrayList<>();
        labelList.add(label);

        doReturn(label).when(labelDao).addLabel(label2);
        doReturn(label).when(labelDao).getLabel(10);
        doReturn(labelList).when(labelDao).getAllLabels();

    }

    private void setupArtistDaoMock(){
        artistDao = mock(ArtistDaoJdbcTemplateImpl.class);
        Artist artist = new Artist();
        artist.setId(45);
        artist.setInstagram("fjds");
        artist.setName("ArtistName");
        artist.setTwitter("jifa");

        Artist artist2 = new Artist();
        artist2.setInstagram("fjds");
        artist2.setName("ArtistName");
        artist2.setTwitter("jifa");

        List<Artist> artistList = new ArrayList<>();
        artistList.add(artist);

        doReturn(artist).when(artistDao).addArtist(artist2);
        doReturn(artist).when(artistDao).getArtist(45);
        doReturn(artistList).when(artistDao).getAllArtists();
    }

    private void setupTrackDaoMock(){
        trackDao = mock(TrackDaoJdbcTemplateImpl.class);
        Track track = new Track();
        track.setId(1);
        track.setAlbumId(1);
        track.setTitle("Num1 Hit");
        track.setRunTime(15);

        Track track2 = new Track();
        track2.setAlbumId(1);
        track2.setTitle("Num1 Hit");
        track2.setRunTime(15);

        List<Track> tracks = new ArrayList<>();
        tracks.add(track);

        doReturn(track).when(trackDao).addTrack(track2);
        doReturn(track).when(trackDao).getTrack(1);
        doReturn(tracks).when(trackDao).getAllTracks();
        doReturn(tracks).when(trackDao).getTracksByAlbum(1);
    }


    @Before
    public void setUp() throws Exception{
        setupAlbumDaoMock();
        setupArtistDaoMock();
        setupLabelDaoMock();
        setupTrackDaoMock();

        service = new ServiceLayer(albumDao, artistDao, labelDao, trackDao);
    }

    @Test
    public void saveAlbum(){
        AlbumViewModel avm = new AlbumViewModel();

        avm.setListPrice(new BigDecimal("14.99"));
        avm.setReleaseDate(LocalDate.of(1999 , 05 , 15));
        avm.setTitle("Greatest Hits");

        Artist artist = new Artist();
        artist.setInstagram("fjds");
        artist.setName("ArtistName");
        artist.setTwitter("jifa");
        artist = service.saveArtist(artist);

        avm.setArtist(artist);

        Label label = new Label();
        label.setName("BlahStudios");
        label.setWebsite("www.site.com");
        label = service.saveLabel(label);

        avm.setLabel(label);

        Track track = new Track();
        track.setRunTime(15);
        track.setTitle("Num1 Hit");
        List<Track> tracks = new ArrayList<>();
        tracks.add(track);

        avm.setTracks(tracks);

        avm = service.saveAlbum(avm);

        AlbumViewModel fromService = service.findAlbum(avm.getId());

        assertEquals(avm, fromService);

    }

    @Test
    public void saveFindFindAllArtist() {

        Artist artist = new Artist();
        artist.setInstagram("fjds");
        artist.setName("ArtistName");
        artist.setTwitter("jifa");
        artist = service.saveArtist(artist);

        Artist fromService = service.findArtist(artist.getId());
        assertEquals(artist, fromService);

        List<Artist> artistList = service.findAllArtists();
        assertEquals(1, artistList.size());
        assertEquals(artist, artistList.get(0));
    }

    @Test
    public void saveFindFindAllLabel(){
        Label label = new Label();
        label.setName("BlahStudios");
        label.setWebsite("www.site.com");
        label = service.saveLabel(label);

        Label fromService = service.findLabel(label.getId());

        List<Label> labelList = service.findAllLabels();
        assertEquals(1, labelList.size());
        assertEquals(label, labelList.get(0));
    }

    @Test
    public void updateArtist(){

        Artist artist = new Artist();
        artist.setId(45);
        artist.setInstagram("fjds");
        artist.setName("ArtistName");
        artist.setTwitter("@BandName");

        ArgumentCaptor<Artist> artistCaptor = ArgumentCaptor.forClass(Artist.class);

        doNothing().when(artistDao).updateArtist(artistCaptor.capture());

        service.updateArtist(artist);
        verify(artistDao, times(1)).updateArtist(artistCaptor.getValue());

        artist = artistCaptor.getValue();

        assertEquals(45, artist.getId());
        assertEquals("@BandName", artist.getTwitter());
    }

    @Test
    public void updateLabel(){
        Label label = new Label();
        label.setId(10);
        label.setName("ArtistStudio");
        label.setWebsite("www.site.com");

        ArgumentCaptor<Label> labelCaptor = ArgumentCaptor.forClass(Label.class);

        doNothing().when(labelDao).updateLabel(labelCaptor.capture());

        service.updateLabel(label);
        verify(labelDao, times(1)).updateLabel(labelCaptor.getValue());

        label = labelCaptor.getValue();

        assertEquals(10, label.getId());
        assertEquals("ArtistStudio", label.getName());
    }

    @Test
    public void updateAlbum() {

        AlbumViewModel avm = new AlbumViewModel();

        avm.setId(1);
        avm.setTitle("Greatest Hits");
        avm.setListPrice(new BigDecimal("15.99"));
        avm.setReleaseDate(LocalDate.of(1999 , 05 , 15));

        Artist artist = new Artist();
        artist.setInstagram("fjds");
        artist.setName("ArtistName");
        artist.setTwitter("jifa");
        artist = service.saveArtist(artist);

        avm.setArtist(artist);

        Label label = new Label();
        label.setName("BlahStudios");
        label.setWebsite("www.site.com");
        label = service.saveLabel(label);

        avm.setLabel(label);

        Track track = new Track();
        track.setRunTime(15);
        track.setTitle("Num1 Hit");
        List<Track> tracks = new ArrayList<>();
        tracks.add(track);

        avm.setTracks(tracks);

        ArgumentCaptor<Album> albumCaptor = ArgumentCaptor.forClass(Album.class);

        doNothing().when(albumDao).updateAlbum(albumCaptor.capture());

        service.updateAlbum(avm);
        verify(albumDao, times(1)).updateAlbum(albumCaptor.getValue());

        Album album = albumCaptor.getValue();

        assertEquals(1, album.getId());
        assertEquals(avm.getListPrice(), album.getListPrice());
        assertEquals(avm.getReleaseDate(), album.getReleaseDate());
        assertEquals(avm.getTitle(), album.getTitle());
    }

    @Test
    public void deleteArtist(){
        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(artistDao).deleteArtist(integerCaptor.capture());
        service.removeArtist(45);
        verify(artistDao, times(1)).deleteArtist(integerCaptor.getValue());
        assertEquals(45, integerCaptor.getValue().intValue());
    }

    @Test
    public void deleteLabel() {

        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);

        doNothing().when(labelDao).deleteLabel(integerCaptor.capture());
        service.removeLabel(10);
        verify(labelDao, times(1)).deleteLabel(integerCaptor.getValue());
        assertEquals(10, integerCaptor.getValue().intValue());
    }

    @Test
    public void deleteAlbum(){
        AlbumViewModel avm = new AlbumViewModel();

        avm.setId(1);
        avm.setTitle("Greatest Hits");
        avm.setListPrice(new BigDecimal("15.99"));
        avm.setReleaseDate(LocalDate.of(1999 , 05 , 15));

        Artist artist = new Artist();
        artist.setInstagram("fjds");
        artist.setName("ArtistName");
        artist.setTwitter("jifa");
        artist = service.saveArtist(artist);

        avm.setArtist(artist);

        Label label = new Label();
        label.setName("BlahStudios");
        label.setWebsite("www.site.com");
        label = service.saveLabel(label);

        avm.setLabel(label);

        Track track = new Track();
        track.setRunTime(15);
        track.setTitle("Num1 Hit");
        List<Track> tracks = new ArrayList<>();
        tracks.add(track);

        avm.setTracks(tracks);

        ArgumentCaptor<Integer> albumCaptor = ArgumentCaptor.forClass(Integer.class);

        doNothing().when(albumDao).deleteAlbum(albumCaptor.capture());
        service.removeAlbum(1);
        verify(albumDao, times(1)).deleteAlbum(albumCaptor.getValue());
        assertEquals(1, albumCaptor.getValue().intValue());

    }
}