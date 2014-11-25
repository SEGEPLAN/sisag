using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace solicitud.Model
{
    public class solicitud_capacitacion
    {
        private string _ID;
        private estado _ESTADO;
        private int _TOTAL_PERSONAS;
        private IList<detalle_necesidad> _DETALLE_NECESIDAD = new List<detalle_necesidad>();
        private usuario _USUARIO_CREA;
        private usuario _USUARIO_VALIDA;

        public solicitud_capacitacion()
        {
            throw new System.NotImplementedException();
        }

        public solicitud_capacitacion(string pID, int pTotal_personas)
        {
            throw new System.NotImplementedException();
        }

        public string ID
        {
            get { return _ID; }
            set { _ID = value; }
        }

        public estado ESTADO
        {
            get { return _ESTADO; }
            set { _ESTADO = value; }
        }

        public int TOTAL_PERSONAS
        {
            get { return _TOTAL_PERSONAS; }
            set { _TOTAL_PERSONAS = value; }
        }

        public usuario USUARIO_CREA
        {
            get { return _USUARIO_CREA; }
            set { _USUARIO_CREA = value; }
        }

        public usuario USUARIO_VALIDA
        {
            get { return _USUARIO_VALIDA; }
            set { _USUARIO_VALIDA = value; }
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

        public solicitud_capacitacion recuperarObjeto(string pID)
        {
            throw new System.NotImplementedException();
        }

        public IList<detalle_necesidad> recuperarObjetos()
        {
            throw new System.NotImplementedException();
        }

        public IList<detalle_necesidad> recuperarDetalles(detalle_necesidad pID)
        {
            throw new System.NotImplementedException();
        }

        public IList<detalle_necesidad> recuperarSolicitud_estado(string pEstado)
        {
            throw new System.NotImplementedException();
        }
    }
}
