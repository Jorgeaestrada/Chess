package com.chess.engine.pieces;

import  com.chess.engine.Alliance;
import  com.chess.engine.board.Board;
import  com.chess.engine.board.Move;
import  com.chess.engine.board.Tile;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
	
	/*
	 * Array of possible avaible moves
	 */
	private final static int[] CANDIDATE_MOVE_COORDINATES = {-17, -15, -10, -6, 6, 10, 15, 17};
	
	/*
	 * Super constructor
	 */
	Knight(final int piecePosition, final Alliance pieceAlliance){
		super(piecePosition, pieceAlliance);
	}
	
	/*
	 * Method that calculates all the possible avaible legal moves
	 * and stores on a List of legal moves, 
	 * 
	 */
	@override
	public Collection<Move> calculateLegalMoves(Board board){
		
		int candidateDestinationCoordinate;
		final List<Move> legalMoves = new ArrayList<>();
		
		/*
		 * cicle that iterates through of {-17, -15, -10, -6, 6, 10, 15, 17};
		 */
		for(final int currentCandidateOffset: CANDIDATE_MOVE_COORDINATES){
			
			final int candidateDestinationCoordinate = this.piecePosition + currentCandidateOffset;
			
			/*
			 * isValidTileCoordinate
			 */
			if(BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate){
				
				if(isFirstColumnExclusion(this.piecePosition, currentCandidateOffset) ||
				isSecondColumnExclusion(this.piecePosition, currentCandidateOffset) ||
				isSeventhColumnExclusion(this.piecePosition, currentCandidateOffset) ||
				isEigthColumnExclusion(this.piecePosition, currentCandidateOffset)){
					continue;
				}
				
				final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);
				
				if (!candidateDestinationTile.isTileOccupied(){
					legalMoves.add(new Move());
				} else {
					
					final Piece pieceAtDestination = candidateDestinationTile.getPiece();
					final Alliance pieceAlliance = pieceDestination.getPieceAlliance();
					
					if(this.pieceAlliance != pieceAlliance) {
						legalMoves.add(new Move());
					}		
				}	
			}
		}
		
		return ImmutableList.copyOf(legalMoves);
	}
	
	private static boolean isFirstColumnExclusion(final int currentPosition, final int candidateOffset){
		return BoardUtils.FIRST_COLUMN[currentPosition] && (candidateOffset == -17 || candidateOffset == -10 ||
			candidateOffset == 6 || candidateOffset == 15);
	}
	
	private static boolean isSecondColumnExclusion(final int currentPosition, final int candidateOffset){
		return BoardUtils.SECOND_COLUMN[currentPosition] && (candidateOffset == 6 || candidateOffset == -10);
	}
		
	private static boolean isSeventhColumnExclusion(final int currentPosition, final int candidateOffset){
		return BoardUtils.SEVENTH_COLUMN[currentPosition] && (candidateOffset == 10 || candidateOffset == -6);
	}
	
	private static boolean isEigthColumnExclusion(final int currentPosition, final int candidateOffset){	
		return BoardUtils.EIGTH_COLUMN[currentPosition] && (candidateOffset == 17 || candidateOffset == 10 ||
			candidateOffset == -6 || candidateOffset == -15);
	}
}


