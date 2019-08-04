package com.chess.engine.board;

import com.chess.engine.pieces.Piece;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

/*
 * Abstract Tile Class, it does not allow to create an instance of yourself
 */
public abstract class Tile {
	
	protected final int tileCoordinate;
	
	private Tile(int tileCoordinate) {
		this.tileCoordinate = tileCoordinate;
	}
	
	private static final Map<Integer, EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();
	
	/*
	 * Method that creates all Tiles for the chessboard
	 */ 
	private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {
		final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();
		
		for(int i = 0; i < 64; i++){
				emptyTileMap.put(i, new EmptyTile(i));
		}
		
		return immutableMap.copyOf(emptyTileMap);
	}
	
	/*
	 * Factory method that allow us to create an Empty or Occupied Tile
	 */
	public static Tile createTile(final int tileCoordinate, final Piece piece) {
		return piece != null ? new OccupiedTile(tileCoordinate, piece) : EMPTY_TILES_CACHE.get(tileCoordinate);
	}
	
	public abstract boolean isTileOccupied();
	
	public abstract Piece getPiece();
	
	/*
	 * Empty Tile class that extends from Tile class
	 */
	public static final class EmptyTile extends Tile{
		
		EmptyTile(final int coordinate){
			super(coordinate);
		}
		
		@override
		public boolean isTileOccupied(){
			return false;
		}
		
		@override
		public Piece getPiece() {
			return null;
		}
	}
	
	/*
	 * Occupied Tile class that extends from Tile class
	 */
	public static final class OccupiedTile extends Tile {
	
		private final Piece pieceOnTile;
	
		private OccupiedTile(int tileCoordinate, Piece pieceOnTile) {
			super(tileCoordinate)
			this.pieceOnTile = pieceOnTile;
		}
		
		@Override
		public boolean isTileOccupied() {
			return true;
		}
		
		@override 
		public Piece getPiece() {
			return this.pieceOnTile;
		}
	}
}
