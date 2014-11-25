using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace solicitud.Model
{
    public class detalle_necesidad
    {
        private string _ID;
        private string _DESCRIPCION;
        private string _PRIORIDAD;
        private int _NIVEL_CONOCIMIENTO;
        private int _DURACION;
        private tema_curso _TEMA;
        private caracter_necesidad _CARACTER;
        private solicitud_capacitacion _SOLICITUD;

        public detalle_necesidad()
        {
            throw new System.NotImplementedException();
        }

        public detalle_necesidad(string pID)
        {
            throw new System.NotImplementedException();
        }

        public string ID
        {
            get { return _ID; }
            set { _ID = value; }
        }

        public string DESCRIPCION
        {
            get { return _DESCRIPCION; }
            set { _DESCRIPCION = value; }
        }

        public string PRIORIDAD
        {
            get { return _PRIORIDAD; }
            set { _PRIORIDAD = value; }
        }

        public int NIVEL_CONOCIMIENTO
        {
            get { return _NIVEL_CONOCIMIENTO; }
            set { _NIVEL_CONOCIMIENTO = value; }
        }

        public int DURACION
        {
            get { return _DURACION; }
            set { _DURACION = value; }
        }

        public tema_curso TEMA
        {
            get { return _TEMA; }
            set { _TEMA = value; }
        }

        public caracter_necesidad CARACTER
        {
            get { return _CARACTER; }
            set { _CARACTER = value; }
        }

        public solicitud_capacitacion SOLICITUD
        {
            get { return _SOLICITUD; }
            set { _SOLICITUD = value; }
        }

        public void Actualizar()
        {
            throw new System.NotImplementedException();
        }

        public bool Eliminar(string pID)
        {
            throw new System.NotImplementedException();
        }

        public bool Persistencia()
        {
            throw new System.NotImplementedException();
        }

        public detalle_necesidad recuperarObjeto(string pID)
        {
            throw new System.NotImplementedException();
        }

        public IList<detalle_necesidad> recuperarObjetos()
        {
            throw new System.NotImplementedException();
        }

        public IList<detalle_necesidad> recuperarDetalle_caracter(caracter_necesidad pCaracter)
        {
            throw new System.NotImplementedException();
        }

        public IList<detalle_necesidad> recuperarDetalle_solicutud(solicitud_capacitacion pSolicitud)
        {
            throw new System.NotImplementedException();
        }
    }
}
