/*
 * generated by Xtext 2.10.0
 */
package org.xtext.example.playlist.m3u.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.xtext.example.playlist.m3u.m3U.M3UPackage;
import org.xtext.example.playlist.m3u.m3U.Model;
import org.xtext.example.playlist.m3u.m3U.Video;
import org.xtext.example.playlist.m3u.services.M3UGrammarAccess;

@SuppressWarnings("all")
public class M3USemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private M3UGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == M3UPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case M3UPackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case M3UPackage.VIDEO:
				sequence_Video(context, (Video) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     listVideo+=Video+
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Video returns Video
	 *
	 * Constraint:
	 *     location=STRING
	 */
	protected void sequence_Video(ISerializationContext context, Video semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, M3UPackage.Literals.VIDEO__LOCATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, M3UPackage.Literals.VIDEO__LOCATION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getVideoAccess().getLocationSTRINGTerminalRuleCall_0(), semanticObject.getLocation());
		feeder.finish();
	}
	
	
}
