package com.chess.engine.pieces;

import com.chess.engine.Alliance;

import com.chess.engine.board.Move;

import java.util.List;

public abstract class Piece {
	
	protected final int piecePosition;
	protected final Alliance pieceAlliance;
	
	/*
	 * when us creates a piece this contains a position
	 * and alliance
	 */
	Piece(final int piecePosition, final Alliance pieceAlliance){
		this.piecePosition = piecePosition;
		this.pieceAlliance = pieceAlliance;
	}
	
	public Alliance getPieceAlliance() {
		return this.pieceAlliance;
	}
	
	/*
	 * Calculates the legal moves for pieces
	 */
	public abstract Collection<Move> calculateLegalMoves(final Board board);
}
