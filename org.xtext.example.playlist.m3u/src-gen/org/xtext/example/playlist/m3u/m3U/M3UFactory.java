/**
 * generated by Xtext 2.10.0
 */
package org.xtext.example.playlist.m3u.m3U;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.xtext.example.playlist.m3u.m3U.M3UPackage
 * @generated
 */
public interface M3UFactory extends EFactory
{
  /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  M3UFactory eINSTANCE = org.xtext.example.playlist.m3u.m3U.impl.M3UFactoryImpl.init();

  /**
	 * Returns a new object of class '<em>Model</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model</em>'.
	 * @generated
	 */
  Model createModel();

  /**
	 * Returns a new object of class '<em>Video</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Video</em>'.
	 * @generated
	 */
  Video createVideo();

  /**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
  M3UPackage getM3UPackage();

} //M3UFactory
